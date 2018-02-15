package br.com.drogaria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.drogaria.domain.Usuario;
@ManagedBean(name="loginBean")
public class LoginBean {
	private Usuario usuario = new Usuario();

	public String doEfetuarLogin() {
		if("admin".equals(usuario.getLogin())
				&& "123".equals(usuario.getSenha())) {

			return "principal";

		} else {

			FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
			FacesContext.getCurrentInstance().addMessage("erro", msg);

			return null;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
