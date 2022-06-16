package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Buffet;
import it.uniroma3.siw.repository.BuffetRepository;


@Service
public class BuffetService {
	
	@Autowired
	BuffetRepository buffetRepo;
	
	@Transactional
	public Buffet salva (Buffet b) {
		return this.buffetRepo.save(b);
	}
	
	@Transactional
	public void cancella (Buffet b) {
		this.buffetRepo.delete(b);
	}
	
	@Transactional
	public void cancellaTutti () {
		this.buffetRepo.deleteAll();
	}
	
	@Transactional
	public Long conta () {
		return this.buffetRepo.count();
	}
	
	@Transactional
	public List<Buffet> listaBuffets () {
		return (List<Buffet>) this.buffetRepo.findAll();
	}
	
	@Transactional
	public List<Buffet> cercaNome (String nome) {
		return this.buffetRepo.findByNome(nome);
	}
	
	@Transactional
	public Buffet cercaId (Long id) {
		return this.buffetRepo.findById(id).get();
	}
	
	@Transactional
	  public List<Buffet> listaBuffetsPerNomeAsc () {
		  return (List<Buffet>)this.buffetRepo.findAllByOrderByNomeAsc();
	  }
	  
	  @Transactional 
	  public List<Buffet> listaBuffetsPerNomeDesc () {
		  return (List<Buffet>)this.buffetRepo.findAllByOrderByNomeDesc();
	  }
}
