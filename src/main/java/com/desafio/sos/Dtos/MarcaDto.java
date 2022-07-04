package com.desafio.sos.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MarcaDto {

	@NotBlank
	@Size(max=100)
	private String nomeMarca;

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	
	
}
