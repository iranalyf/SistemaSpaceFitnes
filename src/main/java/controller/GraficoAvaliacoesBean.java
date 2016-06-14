package controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import controller.LoginUsuarioBean;
import dao.CadastroAvaliacaoDAO;
import model.AvaliacaoFisica;

@ManagedBean
public class GraficoAvaliacoesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private LineChartModel lineModel1;
	private CadastroAvaliacaoDAO dao;

	@PostConstruct
	public void init() {
		createLineModels();
	}

	public LineChartModel getLineModel1() {
		return lineModel1;
	}

	private void createLineModels() {
		lineModel1 = initLinearModel();
		lineModel1.setTitle("Avaliações Feitas");
		lineModel1.setLegendPosition("e");
		lineModel1.setShowPointLabels(true);
		lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Data "));
		Axis yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setLabel("Centimetros");

		yAxis.setMin(0);
		yAxis.setMax(80);

	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		LoginUsuarioBean login = (LoginUsuarioBean) session.getAttribute("loginUsuarioBean");
		List<AvaliacaoFisica> avaliacoes = getDao().avaliacao(login.getUser().getIdUsuario());

		LineChartSeries seriePeitoral = new LineChartSeries();
		LineChartSeries serieBiceps = new LineChartSeries();
		LineChartSeries serieTriceps = new LineChartSeries();
		LineChartSeries serieAbdomen = new LineChartSeries();
		LineChartSeries serieCintura = new LineChartSeries();
		LineChartSeries serieQuadril = new LineChartSeries();
		LineChartSeries serieBracoDireito = new LineChartSeries();
		LineChartSeries serieBracoEsquerdo = new LineChartSeries();
		LineChartSeries serieCoxaDireita = new LineChartSeries();
		LineChartSeries serieCoxaEsquerda = new LineChartSeries();
		LineChartSeries seriePernaDireita = new LineChartSeries();
		LineChartSeries seriePernaEsquerda = new LineChartSeries();
		LineChartSeries serieOmbros = new LineChartSeries();
		LineChartSeries seriePescoco = new LineChartSeries();

		seriePeitoral.setLabel("Peitoral");
		serieBiceps.setLabel("Biceps");
		serieTriceps.setLabel("Tríceps");
		serieAbdomen.setLabel("Abdomen");
		serieCintura.setLabel("Cintura");
		serieQuadril.setLabel("Quadril");
		serieBracoDireito.setLabel("Braço Direito");
		serieBracoEsquerdo.setLabel("Braço Esquerdo");
		serieCoxaDireita.setLabel("Coxa Direita");
		serieCoxaEsquerda.setLabel("Coxa Esquerda");
		seriePernaDireita.setLabel("Perna Direita");
		seriePernaEsquerda.setLabel("Perna Esquerda");
		serieOmbros.setLabel("Ombros");
		seriePescoco.setLabel("Pescoço");

		DateFormat dt = DateFormat.getDateInstance();

		for (AvaliacaoFisica avaliacaoFisica : avaliacoes) {
			seriePeitoral.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getPeitoral());
			serieBiceps.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getBiceps());
			serieTriceps.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getTriceps());

			serieAbdomen.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getAbdomen());
			serieCintura.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getCintura());
			serieQuadril.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getQuadril());
			serieBracoDireito.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getBracoDireito());
			serieBracoEsquerdo.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getBracoEsquerdo());
			serieCoxaDireita.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getCoxaDireita());
			serieCoxaEsquerda.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getCoxaEsquerda());
			seriePernaDireita.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getPernaDireita());
			seriePernaEsquerda.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getPernaEsquerda());
			serieOmbros.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getOmbros());
			seriePescoco.set(dt.format(avaliacaoFisica.getDataAvaliacao()), avaliacaoFisica.getPescoco());

		}

		model.addSeries(seriePeitoral);
		model.addSeries(serieBiceps);
		model.addSeries(serieTriceps);
		model.addSeries(serieAbdomen);
		model.addSeries(serieCintura);
		model.addSeries(serieQuadril);
		model.addSeries(serieBracoDireito);
		model.addSeries(serieBracoEsquerdo);
		model.addSeries(serieCoxaDireita);
		model.addSeries(serieCoxaEsquerda);
		model.addSeries(seriePernaDireita);
		model.addSeries(seriePernaEsquerda);
		model.addSeries(serieOmbros);
		model.addSeries(seriePescoco);

		return model;
	}

	public CadastroAvaliacaoDAO getDao() {
		if (dao == null) {
			dao = new CadastroAvaliacaoDAO();
		}

		return dao;
	}

	public void setDao(CadastroAvaliacaoDAO dao) {
		this.dao = dao;
	}
}