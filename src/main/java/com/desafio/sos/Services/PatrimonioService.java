package com.desafio.sos.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.desafio.sos.Models.Patrimonio;
import com.desafio.sos.Repositories.PatrimonioRepository;

@Service
public class PatrimonioService {
	
	final PatrimonioRepository patrimoniorepository; 
	
	public PatrimonioService(PatrimonioRepository patrimoniorepository) {
		this.patrimoniorepository = patrimoniorepository;
	}
	
	@Transactional
	public Patrimonio save(Patrimonio patrimonio) {
		return patrimoniorepository.save(patrimonio);
	}
	
	public List<Patrimonio> findAll() {
		return patrimoniorepository.findAll();
	}
	
	public Optional<Patrimonio> findById(UUID ndoTombo){
		return patrimoniorepository.findById(ndoTombo);
	}
	
	public void delete(Patrimonio patrimonio) {
		patrimoniorepository.delete(patrimonio);
	}
}
