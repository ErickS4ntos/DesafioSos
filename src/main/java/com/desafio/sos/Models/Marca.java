package com.desafio.sos.Models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_MARCAS")
public class Marca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private UUID marcaId;
	
	@Column(nullable= false, length=100)
	private String nomeMarca;

	public UUID getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(UUID marcaId) {
		this.marcaId = marcaId;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	
	
}
