/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jaciara
 */
public class ConexaoMySQL {
    
    private static ConexaoMySQL instance = null;
    private Connection connection = null;
   
    private ConexaoMySQL(){
        try{
            String driverName = "com.mysql.jdbc." + "Driver";
            Class.forName(driverName);
        
            String serverName = "127.0.0.1";
            String nomeBanco = "transacoesBD";
            String url = "jdbc:mysql://" + serverName + "/" + nomeBanco;
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        
            if(connection != null){
                System.out.println("Conectado com sucesso");
            } else {
                System.out.println("Conexão não estabelecida");
            }
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException e){
            //O driver não foi encontrado
            System.out.append("O driver especificado não foi encontrado.");
        } catch (SQLException e){
            //Conexão com o banco não foi conseguida
            System.out.append("Não foi possível conectar ao Banco de Dados.");
        }
        }
    public static ConexaoMySQL getInstance(){
        if(instance == null){
            instance = new ConexaoMySQL();
        }
        return instance;
    }
    public Connection getConnection() {
            return connection;
    }
}    
    
