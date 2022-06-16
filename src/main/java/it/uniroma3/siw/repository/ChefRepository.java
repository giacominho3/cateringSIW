package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Chef;

public interface ChefRepository extends CrudRepository<Chef, Long> {
	
	public List<Chef> findByNome(String nome);
	public Chef findByCognome(String cognome);
	public List<Chef> findByNazionalita(String nazionalita);
	public List<Chef> findAllByOrderByNomeAsc();
	public List<Chef> findAllByOrderByNomeDesc();
	public List<Chef> findAllByOrderByCognomeAsc();
	public List<Chef> findAllByOrderByCognomeDesc();
	public List<Chef> findAllByOrderByNazionalitaAsc();
	public List<Chef> findAllByOrderByNazionalitaDesc();
}