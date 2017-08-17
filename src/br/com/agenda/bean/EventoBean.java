package br.com.agenda.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.agenda.DAO.EventoDAO;
import br.com.agenda.model.Evento;

@ManagedBean
@ViewScoped
public class EventoBean implements Serializable {

	private static final long serialVersionUID = 8458259708861027697L;

	private Evento evento;
	private ScheduleModel eventModel;
	private List<Evento> listaEvento;
	private EventoDAO eDAO;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public List<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}

	public EventoDAO geteDAO() {
		return eDAO;
	}

	public void seteDAO(EventoDAO eDAO) {
		this.eDAO = eDAO;
	}

	@PostConstruct
	public void inicializar() {

		eDAO = new EventoDAO();
		evento = new Evento();
		eventModel = new DefaultScheduleModel();

		listaEvento = eDAO.listar();

		for (Evento ev : listaEvento) {
			DefaultScheduleEvent evt = new DefaultScheduleEvent();
			evt.setStartDate(ev.getInicioEvento());	
			evt.setEndDate(ev.getFimEvento());				
			evt.setTitle(ev.getTitutloEvento());
			evt.setData(ev.getIdEvento());
			evt.setDescription(ev.getDescEvento());
			evt.setAllDay(true);
			evt.setEditable(true);
			eventModel.addEvent(evt);
		}

	}

	public void quandoSelecionado(SelectEvent selectEvent) {
		ScheduleEvent eventoClicado = (ScheduleEvent) selectEvent.getObject();
		for (Evento elemento : listaEvento) {
			if (elemento.getIdEvento() == (Long) eventoClicado.getData()) {
				evento = elemento;
				break;
			}
		}
	}
	
}
