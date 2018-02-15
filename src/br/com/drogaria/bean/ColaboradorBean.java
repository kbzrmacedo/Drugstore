package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ColaboradorDAO;
import br.com.drogaria.domain.Colaborador;

@ManagedBean(name = "MBColaborador")
@ViewScoped
public class ColaboradorBean {
	private ArrayList<Colaborador> itens;
	private ArrayList<Colaborador> itensFiltrados;
	private Colaborador Colaborador;
	private ArrayList<Colaborador> comboColaboradores;
	
	public ArrayList<Colaborador> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Colaborador> itens) {
		this.itens = itens;
	}

	public ArrayList<Colaborador> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Colaborador> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Colaborador getColaborador() {
		return Colaborador;
	}

	public void setColaborador(Colaborador Colaborador) {
		this.Colaborador = Colaborador;
	}

	public ArrayList<Colaborador> getcomboColaboradores() {
		return comboColaboradores;
	}

	public void setcomboColaboradores(ArrayList<Colaborador> comboColaboradores) {
		this.comboColaboradores = comboColaboradores;
	}

	public void carregarListagem() {
		try {
			ColaboradorDAO dao = new ColaboradorDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void prepararNovo() {
		try {
			Colaborador = new Colaborador();

			ColaboradorDAO dao = new ColaboradorDAO();

			comboColaboradores = dao.listar();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void novo() {
		ColaboradorDAO dao = new ColaboradorDAO();
		try {
			dao.salvar(Colaborador);
			
			itens = dao.listar();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		
	}

	public void excluir() {
		try {
			ColaboradorDAO dao = new ColaboradorDAO();
			dao.excluir(Colaborador);
			
			itens = dao.listar();
			
		}catch(SQLException ex){
			ex.getStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			ColaboradorDAO dao = new ColaboradorDAO();
			
			comboColaboradores = dao.listar();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			ColaboradorDAO dao = new ColaboradorDAO();
			dao.editar(Colaborador);
			
			itens = dao.listar();
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
