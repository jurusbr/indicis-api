package br.com.jurus.indicisapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndicisController {
	
	@Autowired
	private IndiceRepository indiceRepository;
	
	@GetMapping("/")
	public String getInfo() {		
		return "Service Up and Running";
	}

	@GetMapping("/{indice}")
	public ResponseEntity<?> getAllIndices( @PathVariable String indice) {
		
		Integer indiceID = IndiceConverter.convertTpIndice(indice);
		if(indiceID<0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Indice deve ser: cdi, ipca ou igpm"); 
		}
		
		return ResponseEntity.ok(indiceRepository.findTopByTpindiceOrderByDateDesc(indiceID));		
	}
	

	@GetMapping(value="/{indice}", params= {"from","to"})
	public ResponseEntity<?> getAllIndicesFromD1ToD2( @PathVariable String indice,
												@RequestParam String from,
												@RequestParam String to) {
		
		Integer indiceID = IndiceConverter.convertTpIndice(indice);
		if(indiceID<0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Indice deve ser: cdi, ipca ou igpm"); 
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			Date  dtFrom  = format.parse (from);
			Date  dtTo  = format.parse (to);
			
			return ResponseEntity.ok(indiceRepository.findByTpindiceAndDateAfterAndDateBefore(indiceID, dtFrom, dtTo));
		} catch (ParseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datas com formato invaldo. Formato correto: YYYYMMDD"); 
		} 		
		
	}
	
	@GetMapping(value="/{indice}", params= {"days"})
	public ResponseEntity<?> getLastIndicesOfNDays( @PathVariable String indice,
												@RequestParam Integer days) {
		
		
		Integer indiceID = IndiceConverter.convertTpIndice(indice);
		if(indiceID<0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Indice deve ser: cdi, ipca ou igpm"); 
		}
		

		LocalDate now = LocalDate.now();
		LocalDate from = LocalDate.now().minusDays(days);
        Date dtFrom = Date.from(from.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dtTo = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
		return ResponseEntity.ok(indiceRepository.findByTpindiceAndDateAfterAndDateBefore(indiceID, dtFrom, dtTo));

		
	}

	
}
