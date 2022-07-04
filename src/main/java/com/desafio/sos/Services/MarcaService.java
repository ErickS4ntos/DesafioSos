package com.desafio.sos.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.desafio.sos.Models.Marca;
import com.desafio.sos.Repositories.MarcaRepository;

@Service
public class MarcaService {
	
	final MarcaRepository marcarepository;
	
	public MarcaService(MarcaRepository marcarepository) {
		this.marcarepository = marcarepository;
		}
	@Transactional
	public Marca save(Marca marca) {
		return marcarepository.save(marca);
	}
	
	public boolean existsBynomeMarca(String nomeMarca) {
		return marcarepository.existsBynomeMarca(nomeMarca);
	}
	
	public List<Marca> findAll(){
		return marcarepository.findAll();  
	}
	
	public Optional<Marca> findById(UUID marcaId){
		return marcarepository.findById(marcaId);
	}
	public void delete(Marca marca) {
		marcarepository.delete(marca);
		
	}
	
	
}
