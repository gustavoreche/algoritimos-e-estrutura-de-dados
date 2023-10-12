package reche.api.algoritmo;

import java.util.LinkedList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/busca-binaria")
public class BuscaBinariaController {
	
	@GetMapping
	public ResponseEntity<Long> busca(
			@RequestParam(required = true) int numeroEscolhido
			){
		
		var numeros = new LinkedList<Long>();
		for (long i = 0; i <= 2_000_000; i++) {
			System.out.println("Add: " + i);
			numeros.add(i);
		}
		
		var tempoInicio = System.currentTimeMillis();
		
		
		var teste = numeros.get(numeroEscolhido);
		System.out.println(teste);
		
		var tempoFinal = System.currentTimeMillis();
		
		var resultadoTempo = tempoFinal - tempoInicio;
		System.out.println(resultadoTempo);
		
		tempoInicio = System.currentTimeMillis();
		int divisor = 2_000_000 / 2;
		while (numeroEscolhido != divisor) {
			if (divisor < numeroEscolhido) {
				divisor = divisor + (divisor / 2);
			} else {
				divisor = divisor - (divisor / 2);
			}
		}
		tempoFinal = System.currentTimeMillis();
		resultadoTempo = tempoFinal - tempoInicio;
		System.out.println(resultadoTempo);
		return new ResponseEntity<Long>(resultadoTempo, 
				HttpStatus.OK);
	}

}
