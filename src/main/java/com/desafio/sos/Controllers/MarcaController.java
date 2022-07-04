package com.desafio.sos.Controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.sos.Dtos.MarcaDto;
import com.desafio.sos.Models.Marca;
import com.desafio.sos.Services.MarcaService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/marca")
public class MarcaController {
	
	final MarcaService marcaservice;
	
	public MarcaController(MarcaService marcaservice) {
		this.marcaservice = marcaservice;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveMarca(@RequestBody @Valid MarcaDto marcadto){
		if(marcaservice.existsBynomeMarca(marcadto.getNomeMarca())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito : Este nome já está em uso !!!");
		}
		Marca marca = new Marca();
		BeanUtils.copyProperties(marcadto, marca);
		return ResponseEntity.status(HttpStatus.CREATED).body(marcaservice.save(marca));
	}
	
	@GetMapping
	public ResponseEntity<List<Marca>> getAllMarca(){
		return ResponseEntity.status(HttpStatus.OK).body(marcaservice.findAll());
	}
	
	@GetMapping("/{marcaId}")
	public ResponseEntity<Object> getOneMarca(@PathVariable(value = "marcaId") UUID marcaId){
		Optional<Marca> marcaOptional = marcaservice.findById(marcaId);
		if(!marcaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada !!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(marcaOptional.get());
	}
	
	@DeleteMapping("/{marcaId}")
	public ResponseEntity<Object> deleteMarca(@PathVariable(value = "marcaId") UUID marcaId){
		Optional<Marca> marcaOptional = marcaservice.findById(marcaId);
		if(!marcaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada !!!");
		}
		marcaservice.delete(marcaOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Marca deletada com sucesso !!!");
		
	}
	
	@PutMapping("{marcaId}")
	public ResponseEntity<Object> updateMarca(@PathVariable(value = "marcaId") UUID marcaId,
													@RequestBody @Valid MarcaDto marcadto){
		Optional<Marca> marcaOptional = marcaservice.findById(marcaId);
		if(!marcaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada !!!");
		}
		Marca marca = marcaOptional.get();
		marca.setNomeMarca(marcadto.getNomeMarca());
		return ResponseEntity.status(HttpStatus.OK).body(marcaservice.save(marca));
	}
	
	public ModelAndView indexMarca() {
		return new ModelAndView("marca");
	}
}

