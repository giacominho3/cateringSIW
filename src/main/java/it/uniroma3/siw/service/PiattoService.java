package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Piatto;
import it.uniroma3.siw.repository.PiattoRepository;

@Service
public class PiattoService {

	@Autowired
	PiattoRepository piattoRepo;
	
	@Transactional
	public Piatto salva (Piatto b) {
		return this.piattoRepo.save(b);
	}
	
	@Transactional
	public void cancella (Piatto b) {
		this.piattoRepo.delete(b);
	}
	
	@Transactional
	public void cancellaTutti () {
		this.piattoRepo.deleteAll();
	}
	
	@Transactional
	public Long conta () {
		return this.piattoRepo.count();
	}
	
	@Transactional
	public List<Piatto> listaPiatti () {
		return (List<Piatto>) this.piattoRepo.findAll();
	}
	
	@Transactional
	public Piatto cercaId (Long id) {
		return this.piattoRepo.findById(id).get();
	}
	
	@Transactional
	  public List<Piatto> listaPiattiPerNomeAsc () {
		  return (List<Piatto>)this.piattoRepo.findAllByOrderByNomeAsc();
	  }
	  
	  @Transactional 
	  public List<Piatto> listaPiattiPerNomeDesc () {
		  return (List<Piatto>)this.piattoRepo.findAllByOrderByNomeDesc();
	  }
}
