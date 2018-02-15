package br.com.drogaria.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

@ManagedBean ( name = "MBFile")
@ViewScoped
public class FileBean {
	private UploadedFile file;
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}


	public void upload(){

		if(file != null) {
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader((file.getInputstream())));
				leitura(br);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
						
			}
			FacesMessage message = new FacesMessage("Arquivo", file.getFileName() + " adicionado com sucesso !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public static void leitura(BufferedReader br ) throws IOException, SQLException {

		try {
			String s = br.readLine();
			
			while (s != null) {
				String descricao;
				double preco;
				Long qtd;
				long id;
				
				StringTokenizer st = null;
				st = new StringTokenizer(s, ";");

				descricao = st.nextToken();
				preco = Double.parseDouble(st.nextToken());
				qtd = Long.parseLong(st.nextToken());
				id = Long.parseLong(st.nextToken());

				Fabricante f = new Fabricante();
				f.setCodigo(id);

				Produto p1 = new Produto();
				p1.setDescricao(descricao);
				p1.setPreco(preco);
				p1.setQuantidade(qtd);
				p1.setFabricante(f);

				ProdutoDAO dao = new ProdutoDAO();
				dao.salvar(p1);
				s = br.readLine(); // pular a linha para voltar

			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}