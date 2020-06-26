package br.com.jurus.indicisapi;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IndiceRepository extends CrudRepository<Indice, Integer> {
	
	List<Indice> findTopByTpindiceOrderByDateDesc(Integer tpindice);
	List<Indice> findByTpindiceAndDateAfterAndDateBefore(Integer tpindice, Date endDate, Date startDate);

}
