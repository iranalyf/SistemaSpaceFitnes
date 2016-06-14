package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.CadastroAvaliacaoDAO;
import model.AvaliacaoFisica;
import util.UtilMensagens;

@ManagedBean
@RequestScoped
public class CadastroAvaliacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AvaliacaoFisica avaliacao;
	private CadastroAvaliacaoDAO dao;
	private UtilMensagens messages;
	
	public CadastroAvaliacaoBean(){
		this.avaliacao = new AvaliacaoFisica();
		this.dao = new CadastroAvaliacaoDAO();
		this.messages = new UtilMensagens();
	}

	public void cadastrarAvaliacaoFisica() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		LoginUsuarioBean login = (LoginUsuarioBean) session.getAttribute("loginUsuarioBean");
		getAvaliacao().setUsuario(login.getUser());
		getDao().cadastrarAvaliacao(avaliacao);
		messages.info("Avaliação Cadastrada com Sucesso!");
	}

	public AvaliacaoFisica getAvaliacao() {
		if (avaliacao == null) {
			avaliacao = new AvaliacaoFisica();
		}
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoFisica avaliacao) {
		this.avaliacao = avaliacao;
	}

	public CadastroAvaliacaoDAO getDao() {
		if (dao == null) {
			dao = new CadastroAvaliacaoDAO();
		}

		return dao;
	}

}
