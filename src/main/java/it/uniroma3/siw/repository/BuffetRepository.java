package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Buffet;

public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
	public List<Buffet> findByNome(String nome);
	public List<Buffet> findAllByOrderByNomeAsc();
	public List<Buffet> findAllByOrderByNomeDesc();
}
