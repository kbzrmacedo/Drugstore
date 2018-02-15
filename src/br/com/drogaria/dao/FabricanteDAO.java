package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.*;
import br.com.drogaria.factory.ConnectionFactory;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante "); //Utiliza um método de junção ao invés de utilizar o +
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString()); //executa comandos sql

		comando.setString(1, f.getDescricao());//acionando o objeto para o ponto de interrogação, setString pois a descrição é em string.

		comando.executeUpdate();
	}
	
	public void excluir(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConnectionFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		comando.executeUpdate();
	}
	
	public void editar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET DESCRICAO = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConnectionFactory.conectar();
		 
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		
		comando.executeUpdate();
	}

	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("Select codigo, descricao  ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConnectionFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		
		Fabricante retorno = null;
		
		if(resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		 
		return retorno;
		
	} 
	
	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("Select codigo, descricao  ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConnectionFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString()); 
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			
			lista.add(f);
		}
		return lista;
	}

	public ArrayList<Fabricante> bucarPorDescricao(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConnectionFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString()); 
		comando.setString(1, "%" + f.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();
		
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()) {
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			
			lista.add(item);
		}
		return lista;
	}
	public static void main(String[] args) {
		//Teste de INSERT
//		Fabricante f1 = new Fabricante();
//		f1.setDescricao("Desc 1");
//
//		Fabricante f2 = new Fabricante();
//		f2.setDescricao("Desc 2");
//
//		FabricanteDAO fdao = new FabricanteDAO();
//
//		try {
//			fdao.salvar(f1);
//			fdao.salvar(f2);
//			System.out.println("Deu certo");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Deu Ruim");
//		}
//			
//				//Teste de DELETE
//		Fabricante f1 = new Fabricante();
//		f1.setCodigo(2L);
//		
//		Fabricante f2 = new Fabricante();
//		f2.setCodigo(1L);
//		
//		FabricanteDAO fdao = new FabricanteDAO();
//		
//		try {
//			fdao.excluir(f1);
//			fdao.excluir(f2);
//			System.out.println("Sucesso");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Deu ruim");
//		}
		
//		////Teste de UPDATE
//		Fabricante f1 = new Fabricante();
//		f1.setCodigo(3L);
//		f1.setDescricao("DESCRICAO 3");
//		
//		FabricanteDAO fdao = new FabricanteDAO();
//		
//		try {
//			fdao.editar(f1	);
//			System.out.println("Sucesso");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Erro");
//		}
		
//		//Listar apenas 1
//		Fabricante f1 = new Fabricante();
//		f1.setCodigo(4L);
//		
//		Fabricante f2 = new Fabricante();
//		f2.setCodigo(6L);
//		
//		FabricanteDAO fdao = new FabricanteDAO();
//		
//		try {
//			Fabricante f3 = fdao.buscarPorCodigo(f1);
//			Fabricante f4 = fdao.buscarPorCodigo(f2);
//			
//			System.out.println("Result 1: " + f3);
//			System.out.println("Result 2: " + f4);
//		} catch (SQLException e) {
//			System.out.println("Erro");
//			e.printStackTrace();
//		}
//		
//		//Listar tudo
//		FabricanteDAO fdao = new FabricanteDAO();
//		try {
//			ArrayList<Fabricante> lista = fdao.listar();
//			
//			for(Fabricante f : lista) {
//				System.out.println(f);
//			}
//		} catch (SQLException e) {
//			System.out.println("Deu ERRO");
//			e.printStackTrace();
//		}
		
//		//Buscar por desc
//		Fabricante f1 = new Fabricante();
//		f1.setDescricao("2");
//		
//		FabricanteDAO fdao = new FabricanteDAO();
//		
//		try {
//			ArrayList<Fabricante> lista = fdao.bucarPorDescricao(f1);
//			
//			for(Fabricante f : lista) {
//				System.out.println("Result: " + f);
//			}
//		} catch (SQLException e) {
//			System.out.println("Deu ERRO");
//			e.printStackTrace();
//		}
	
		
	}
}
