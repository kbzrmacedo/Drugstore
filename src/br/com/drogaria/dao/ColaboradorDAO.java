package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.dao.ColaboradorDAO;
import br.com.drogaria.domain.Colaborador;
import br.com.drogaria.factory.ConnectionFactory;


public class ColaboradorDAO {
	public void salvar(Colaborador c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO colaborador "); //Utiliza um método de junção ao invés de utilizar o +
		sql.append("(nome, cargo) ");
		sql.append("VALUES (?,?) ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString()); //executa comandos sql

		comando.setString(1, c.getNome());
		comando.setString(2, c.getCargo());	


		comando.executeUpdate();
	}

	public ArrayList<Colaborador> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM colaborador ");


		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString()); 

		ResultSet resultado = comando.executeQuery();

		ArrayList<Colaborador> itens = new ArrayList<Colaborador>();

		while(resultado.next()) {
			Colaborador c = new Colaborador();
			c.setId(resultado.getLong("id"));
			c.setNome(resultado.getString("nome"));
			c.setCargo(resultado.getString("cargo"));

			
			itens.add(c);
		}
		return itens;
	}

	public void excluir(Colaborador c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM colaborador ");
		sql.append("WHERE id = ? ");
		
		Connection conexao = ConnectionFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getId());
		
		comando.executeUpdate();
	}
		

	public void editar(Colaborador c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE colaborador ");
		sql.append("SET nome = ?, cargo = ? ");
		sql.append("WHERE id = ? ");
		
		Connection conexao = ConnectionFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getCargo());
		comando.setLong(3, c.getId());
		
		comando.executeUpdate();

	}
}
