package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "swc123";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useSSL=false";
	
	public static Connection conectar() throws SQLException { //quem chamar o m�todo trata as exceptions
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try { //tenta fazer essa parte
		Connection conexao = ConnectionFactory.conectar(); // n�o utiliza new pois o m�todo � est�tico.
		System.out.println("Conex�o realizada com sucesso!");
		}catch(SQLException ex) { // se der errado vem para o catch, captura o SQLException e mostra o erro.
			ex.printStackTrace(); // mostra os erros no console
			System.out.println("N�o foi poss�vel realizar a conex�o!");
		}
	}
}
