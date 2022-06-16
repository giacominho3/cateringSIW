package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	IngredienteRepository ingredienteRepo;
	
	@Transactional
	public Ingrediente salva (Ingrediente c) {
		return this.ingredienteRepo.save(c);
	}
	
	@Transactional
	public void cancella (Ingrediente c) {
		this.ingredienteRepo.delete(c);
	}
	
	@Transactional
	public void cancellaTutti () {
		this.ingredienteRepo.deleteAll();
	}
	
	@Transactional
	public Long conta () {
		return this.ingredienteRepo.count();
	}
	
	@Transactional
	public Ingrediente cercaId (Long id) {
		return this.ingredienteRepo.findById(id).get();
	}
	
	@Transactional
	public List<Ingrediente> listaIngredienti () {
		return (List<Ingrediente>) this.ingredienteRepo.findAll();
	}
	
	@Transactional 
	public List<Ingrediente> listaPerNomeAsc () {
		return (List<Ingrediente>)this.ingredienteRepo.findAllByOrderByNomeAsc();
	}
	  
	@Transactional 
	public List<Ingrediente> listaPerNomeDesc () { 
		return (List<Ingrediente>)this.ingredienteRepo.findAllByOrderByNomeDesc();
	}
	
	@Transactional 
	public List<Ingrediente> listaPerOrigineAsc () {
		return (List<Ingrediente>)this.ingredienteRepo.findAllByOrderByOrigineAsc();
	}
	  
	@Transactional 
	public List<Ingrediente> listaPerOrigineDesc () { 
		return (List<Ingrediente>)this.ingredienteRepo.findAllByOrderByOrigineDesc();
	}
}
