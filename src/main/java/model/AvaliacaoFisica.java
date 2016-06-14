package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity(name = "AVALIACAO_FISICA")
public class AvaliacaoFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacaoFisica;
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Informe o campo Data da Avaliação")
	private Date dataAvaliacao;
	@NotNull(message = "Informe o campo Biceps")
	private Float biceps;
	@NotNull(message = "Informe o campo Tríceps")
	private Float triceps;
	@NotNull(message = "Informe o campo Abdomen")
	private Float abdomen;
	@NotNull(message = "Informe o campo Quadril")
	private Float quadril;
	@NotNull(message = "Informe o campo Braço Esquerdo")
	private Float bracoEsquerdo;
	@NotNull(message = "Informe o campo Braço Direito")
	private Float bracoDireito;
	@NotNull(message = "Informe o campo Coxa Esquerda")
	private Float coxaEsquerda;
	@NotNull(message = "Informe o campo Coxa Direita")
	private Float coxaDireita;
	@NotNull(message = "Informe o campo perna Esquerda")
	private Float pernaEsquerda;
	@NotNull(message = "Informe o campo Perna Direita")
	private Float pernaDireita;
	@NotNull(message = "Informe o campo Pescoço")
	private Float pescoco;
	@NotNull(message = "Informe o campo Peitoral")
	private Float peitoral;
	@NotNull(message = "Informe o campo Cintura")
	private Float cintura;
	@NotNull(message = "Informe o campo Ombros")
	private Float ombros;


	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public Long getIdAvaliacaoFisica() {
		return idAvaliacaoFisica;
	}

	public void setIdAvaliacaoFisica(Long idAvaliacaoFisica) {
		this.idAvaliacaoFisica = idAvaliacaoFisica;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Float getBiceps() {
		return biceps;
	}

	public void setBiceps(Float biceps) {
		this.biceps = biceps;
	}

	public Float getTriceps() {
		return triceps;
	}

	public void setTriceps(Float triceps) {
		this.triceps = triceps;
	}

	public Float getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(Float abdomen) {
		this.abdomen = abdomen;
	}

	public Float getQuadril() {
		return quadril;
	}

	public void setQuadril(Float quadril) {
		this.quadril = quadril;
	}

	public Float getBracoEsquerdo() {
		return bracoEsquerdo;
	}

	public void setBracoEsquerdo(Float bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	public Float getBracoDireito() {
		return bracoDireito;
	}

	public void setBracoDireito(Float bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	public Float getCoxaEsquerda() {
		return coxaEsquerda;
	}

	public void setCoxaEsquerda(Float coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}

	public Float getCoxaDireita() {
		return coxaDireita;
	}

	public void setCoxaDireita(Float coxaDireita) {
		this.coxaDireita = coxaDireita;
	}

	public Float getPernaEsquerda() {
		return pernaEsquerda;
	}

	public void setPernaEsquerda(Float pernaEsquerda) {
		this.pernaEsquerda = pernaEsquerda;
	}

	public Float getPernaDireita() {
		return pernaDireita;
	}

	public void setPernaDireita(Float pernaDireita) {
		this.pernaDireita = pernaDireita;
	}

	public Float getPescoco() {
		return pescoco;
	}

	public void setPescoco(Float pescoco) {
		this.pescoco = pescoco;
	}

	public Float getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(Float peitoral) {
		this.peitoral = peitoral;
	}

	public Float getCintura() {
		return cintura;
	}

	public void setCintura(Float cintura) {
		this.cintura = cintura;
	}

	public Float getOmbros() {
		return ombros;
	}

	public void setOmbros(Float ombros) {
		this.ombros = ombros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAvaliacaoFisica == null) ? 0 : idAvaliacaoFisica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoFisica other = (AvaliacaoFisica) obj;
		if (idAvaliacaoFisica == null) {
			if (other.idAvaliacaoFisica != null)
				return false;
		} else if (!idAvaliacaoFisica.equals(other.idAvaliacaoFisica))
			return false;
		return true;
	}

}
