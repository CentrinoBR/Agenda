package br.com.agenda.model;

import java.util.Date;

public class Evento {

	private Long idEvento;
	private String titutloEvento;
	private Date inicioEvento;
	private Date fimEvento;
	private String descEvento;
	private Boolean statusEvento;
	
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getTitutloEvento() {
		return titutloEvento;
	}
	public void setTitutloEvento(String titutloEvento) {
		this.titutloEvento = titutloEvento;
	}
	public Date getInicioEvento() {
		return inicioEvento;
	}
	public void setInicioEvento(Date inicioEvento) {
		this.inicioEvento = inicioEvento;
	}
	public Date getFimEvento() {
		return fimEvento;
	}
	public void setFimEvento(Date fimEvento) {
		this.fimEvento = fimEvento;
	}
	public String getDescEvento() {
		return descEvento;
	}
	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}
	public Boolean getStatusEvento() {
		return statusEvento;
	}
	public void setStatusEvento(Boolean statusEvento) {
		this.statusEvento = statusEvento;
	}
}