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

import com.desafio.sos.Dtos.PatrimonioDto;
import com.desafio.sos.Models.Patrimonio;
import com.desafio.sos.Services.PatrimonioService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/patrimonio")
public class PatrimonioController {
	
	
	final PatrimonioService patrimonioservice;
	
	public PatrimonioController(PatrimonioService patrimonioservice) {
		this.patrimonioservice= patrimonioservice;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> savePatrimonio(@RequestBody @Valid PatrimonioDto patrimoniodto){
		Patrimonio patrimonio = new Patrimonio();
		BeanUtils.copyProperties(patrimoniodto, patrimonio);
		return ResponseEntity.status(HttpStatus.CREATED).body(patrimonioservice.save(patrimonio));
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Patrimonio>> getAllPatrimonio(){
		return ResponseEntity.status(HttpStatus.OK).body(patrimonioservice.findAll());
	}
	
	@GetMapping("/readOne/{ndoTombo}")
	public ResponseEntity<Object> getOnePatrimonio(@PathVariable(value="ndoTombo") UUID ndoTombo){
		Optional<Patrimonio> patrimonioptional= patrimonioservice.findById(ndoTombo);
		if(!patrimonioptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patrimonio não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(patrimonioptional.get());
	}
	
	@DeleteMapping("/delete/{ndoTombo}")
	public ResponseEntity<Object> deletePatrimonio(@PathVariable(value="ndoTombo") UUID ndoTombo){
		Optional<Patrimonio> patrimonioptional= patrimonioservice.findById(ndoTombo);
		if(!patrimonioptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patrimonio não encontrado");
		}
		patrimonioservice.delete(patrimonioptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Marca deletada com sucesso");
	}
	
	@PutMapping("/update/{ndoTombo}")
	public ResponseEntity<Object> changePatrimonio(@PathVariable(value="ndoTombo")UUID ndoTombo,
												   @RequestBody	@Valid PatrimonioDto patrimoniodto){
		Optional<Patrimonio> patrimonioptional= patrimonioservice.findById(ndoTombo);
		if(!patrimonioptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patrimonio não encontrado");
		}
		Patrimonio patrimonio = patrimonioptional.get();
		patrimonio.setNome(patrimoniodto.getNome());
		patrimonio.setDescricao(patrimoniodto.getDescricao());
		return ResponseEntity.status(HttpStatus.OK).body(patrimonioservice.save(patrimonio));
	}
	
	public ModelAndView indexPatrimonio() {
		return new ModelAndView("patrimonio");
	}
	
	
}
