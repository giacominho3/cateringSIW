package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.repository.ChefRepository;

@Service
public class ChefService {
	
	@Autowired
	ChefRepository chefRepo;
	
	@Transactional
	public Chef salva (Chef c) {
		return this.chefRepo.save(c);
	}
	
	@Transactional
	public void cancella (Chef c) {
		this.chefRepo.delete(c);
	}
	
	@Transactional
	public void cancellaTutti () {
		this.chefRepo.deleteAll();
	}
	
	@Transactional
	public Long conta () {
		return this.chefRepo.count();
	}
	
	@Transactional
	public Chef cercaId (Long id) {
		return this.chefRepo.findById(id).get();
	}
	
	@Transactional
	public List<Chef> listaChefs () {
		return (List<Chef>) this.chefRepo.findAll();
	}
	
	@Transactional
	public List<Chef> cercaNome (String nome) {
		return this.chefRepo.findByNome(nome);
	}
	
	@Transactional
	public Chef cercaCognome (String cognome) {
		return this.chefRepo.findByCognome(cognome);
	}
	
	@Transactional
	public List<Chef> cercaNazionalità (String nazionalita) {
		return this.chefRepo.findByNazionalita(nazionalita);
	}
	
	@Transactional 
	public List<Chef> listaPerNomeAsc () {
		return (List<Chef>)this.chefRepo.findAllByOrderByNomeAsc();
	}
	  
	@Transactional 
	public List<Chef> listaPerNomeDesc () { 
		return (List<Chef>)this.chefRepo.findAllByOrderByNomeDesc();
	}
	
	@Transactional 
	public List<Chef> listaPerCognomeAsc () {
		return (List<Chef>)this.chefRepo.findAllByOrderByCognomeAsc();
	}
	  
	@Transactional 
	public List<Chef> listaPerCognomeDesc () { 
		return (List<Chef>)this.chefRepo.findAllByOrderByCognomeDesc();
	}
	
	@Transactional
	public List<Chef> listaPerNazionalitaAsc () {
		return (List<Chef>)this.chefRepo.findAllByOrderByNazionalitaAsc();
	}
	
	@Transactional
	public List<Chef> listaPerNazionalitaDesc () {
		return (List<Chef>)this.chefRepo.findAllByOrderByNazionalitaDesc();
	}
}
