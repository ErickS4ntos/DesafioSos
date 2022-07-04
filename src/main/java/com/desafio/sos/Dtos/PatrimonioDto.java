package com.desafio.sos.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PatrimonioDto {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(max=300)
	private String descricao;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
