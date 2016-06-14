
package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.CadastroUsuarioDAO;
import model.Usuario;
import util.UtilMensagens;

@ManagedBean
@SessionScoped
public class LoginUsuarioBean {

	private CadastroUsuarioDAO dao;
	private String nomeusuario;
	private String senha;
	private Usuario user = new Usuario();
	private UtilMensagens messages = new UtilMensagens();

	public LoginUsuarioBean() {

		dao = new CadastroUsuarioDAO();
	}

	public void login() {
		try {
			user = getDao().usuarioLogin(nomeusuario, senha);

			if (user == null) {

				// FacesContext.getCurrentInstance().getExternalContext().redirect("segurancaLogin.xhtml");
				messages.error("Por Favor, confira seu Usuario e Senha e tente novamente");
			} else {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/SistemaSpaceFitnes/dashboard/dash.xhtml");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void logof() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaSpaceFitnes/Home.xhtml");
		} catch (IOException ex) {

			ex.printStackTrace();
		}
	}

	public CadastroUsuarioDAO getDao() {

		if (dao == null) {
			dao = new CadastroUsuarioDAO();
		}
		return dao;
	}

	public void setDao(CadastroUsuarioDAO dao) {
		this.dao = dao;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
