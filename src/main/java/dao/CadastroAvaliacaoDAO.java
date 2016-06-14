package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.AvaliacaoFisica;
import util.UtilMensagens;
import util.UtilErros;

public class CadastroAvaliacaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	private UtilMensagens messages;

	public CadastroAvaliacaoDAO() {

		em = Persistence.createEntityManagerFactory("spacefitnesPU").createEntityManager();
		messages = new UtilMensagens();
	}

	public boolean cadastrarAvaliacao(AvaliacaoFisica avaliacao) {
		try {
			
			em.getTransaction().begin();
			em.persist(avaliacao);
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			messages.error("Falha ao cadastrar a Avaliação" + UtilErros.getMensagemErro(e));
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AvaliacaoFisica> avaliacao(Long idUsuario) {

		em.getTransaction().begin();

		Query q = em.createQuery("select a from AVALIACAO_FISICA as a where a.usuario.idUsuario = :idUsuario");
		q.setParameter("idUsuario", idUsuario);

		List<AvaliacaoFisica> avaliacoes = q.getResultList();

		em.getTransaction().commit();

		return avaliacoes;
	}

}