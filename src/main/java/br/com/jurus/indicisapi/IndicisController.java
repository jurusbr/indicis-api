package br.com.jurus.indicisapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndicisController {
	
	@Autowired
	private IndiceRepository indiceRepository;

	@GetMapping("/indice")
	public Iterable<Indice> getAllIndices( @RequestParam Integer tipo) {
		return indiceRepository.findTopByTpindiceOrderByDateDesc(tipo);
	}
	
}
