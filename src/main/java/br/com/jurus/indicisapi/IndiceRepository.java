package br.com.jurus.indicisapi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IndiceRepository extends CrudRepository<Indice, Integer> {
	
	List<Indice> findByTpindice(Integer tpindice);
	List<Indice> findTopByTpindiceOrderByDateDesc(Integer tpindice);

}
