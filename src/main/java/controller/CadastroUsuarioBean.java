package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.CadastroUsuarioDAO;
import model.Usuario;
import util.UtilMensagens;

@ManagedBean
@RequestScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CadastroUsuarioDAO dao;
	private Usuario user;
	private UtilMensagens messages;
	
	public CadastroUsuarioBean(){
		getUser();
		this.messages = new UtilMensagens();
	}

	public void cadastrarUsuario() {
		getDao().cadastrar(this.user);
		messages.info("Usuario Cadastrado com Sucesso");
	}

	public CadastroUsuarioDAO getDao() {

		if (dao == null) {
			dao = new CadastroUsuarioDAO();
		}

		return dao;
	}

	public Usuario getUser() {

		if (user == null) {
			user = new Usuario();
		}

		return user;
	}

}
