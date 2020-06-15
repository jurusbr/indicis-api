package br.com.jurus.indicisapi;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Indice {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTpindice() {
		return tpindice;
	}
	public void setTpindice(Integer tpindice) {
		this.tpindice = tpindice;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Id
	private Integer id;
	private Integer tpindice;
	private BigDecimal valor;
	private Date date;
}
