package com.desafio.sos.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.sos.Models.Marca;

public interface MarcaRepository extends JpaRepository<Marca, UUID>{
	
	boolean existsBynomeMarca(String nomeMarca);
}
