package br.com.prova.marcos.model.help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitaria para conexao ao banco de dados.
 * @author Marcos
 *
 */
public class DBUtils {
	
 /**
  * Obtem uma conexão com o banco.
  * @return conecction conexao com o banco.
  */
public static java.sql.Connection getConexaoMySQL() {
 
        Connection connection = null;    
 
        try {		
 
        	String driverName = "com.mysql.jdbc.Driver";    
        	Class.forName(driverName);		
			String serverName = "localhost";
            String mydatabase = "mysql";  
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";  
            String password = "adm";    
            
            connection = DriverManager.getConnection(url, username, password);            
 
            return connection;   
 
	    } catch (ClassNotFoundException e) {   
    	   System.out.println("O driver expecificado nao foi encontrado.");		 
           return null;
	 
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");	 
	        return null;	 
	    }  
    }
	 
		

}
