package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;
import util.UtilMensagens;
import util.UtilErros;

public class CadastroUsuarioDAO {

	private EntityManager em;
	private UtilMensagens messages;
	 

	public CadastroUsuarioDAO() {
		em = Persistence.createEntityManagerFactory("spacefitnesPU").createEntityManager();
		messages = new UtilMensagens();

	}

	public boolean cadastrar(Usuario user) {
		try {
			
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();

			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			messages.error("Falha ao cadastrar o Usuario" + UtilErros.getMensagemErro(e));
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Usuario usuarioLogin(String usuario , String senha){
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("select u from USUARIO as u where u.nomUsuario = :user and u.senha= :senha ");
		q.setParameter("user", usuario);
		q.setParameter("senha", senha);
		
		List<Usuario> usuarios = q.getResultList();
		
		em.getTransaction().commit();
		
		if(usuarios.isEmpty()){
			return null;
		}else{
			return usuarios.get(0);
		}
			
	}

}
