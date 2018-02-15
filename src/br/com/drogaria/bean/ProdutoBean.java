package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	private Produto produto;
	private ArrayList<Fabricante> comboFabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}

	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void carregarListagem() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void prepararNovo() {
		try {
			produto = new Produto();

			FabricanteDAO dao = new FabricanteDAO();

			comboFabricantes = dao.listar();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void novo() {
		ProdutoDAO dao = new ProdutoDAO();
		try {
			dao.salvar(produto);
			
			itens = dao.listar();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		
	}

	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			
			itens = dao.listar();
			
		}catch(SQLException ex){
			ex.getStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			comboFabricantes = dao.listar();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			
			dao.editar(produto);
			
			itens = dao.listar();
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
