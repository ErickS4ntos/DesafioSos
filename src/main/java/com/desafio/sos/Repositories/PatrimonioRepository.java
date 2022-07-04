package com.desafio.sos.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.sos.Models.Patrimonio;

public interface PatrimonioRepository extends JpaRepository<Patrimonio, UUID> {

}
