package reche.api.algoritmo;

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
	public ResponseEntity<String> busca(
			@RequestParam(required = true) int numeroEscolhido
			){
		
		int tamanhoDoArray = 2_000_000;				
		
		if (numeroEscolhido > tamanhoDoArray) {
			return new ResponseEntity<String>("""
					Valor maior que o tamanho da lista.
					Tamanho da lista: %s
					""".formatted(tamanhoDoArray), 
					HttpStatus.BAD_REQUEST);
		}
		
		int[] numeros = new int[tamanhoDoArray];
		for (int i = 0; i < tamanhoDoArray; i++) {
			var valor = i+1;
			System.out.println("Add: " + valor);
			numeros[i] = valor;
		}
		
		var tempoInicio = System.currentTimeMillis();
		for (int i = 0; i < tamanhoDoArray; i++) {
			if (numeros[i] == numeroEscolhido) {
				break;
			}
		}
		var tempoFinal = System.currentTimeMillis();
		var resultadoTempoLinear = tempoFinal - tempoInicio;
		
		tempoInicio = System.currentTimeMillis();
		int divisor = tamanhoDoArray / 2;
		var maiorDivisor = tamanhoDoArray;
		while (numeroEscolhido != divisor) {
			System.out.println("Divisor: " + divisor);
			if (divisor < numeroEscolhido) {
				divisor = divisor + calculaAdicao(maiorDivisor, divisor);
			} else {
				maiorDivisor = divisor;
				divisor = divisor / 2;
			}
		}
		tempoFinal = System.currentTimeMillis();
		var resultadoTempoBuscaBinaria = tempoFinal - tempoInicio;

		return new ResponseEntity<String>("""
				Tempo da Busca linear: %s ms
				Tempo da Busca binária: %s ms
				""".formatted(resultadoTempoLinear, resultadoTempoBuscaBinaria), 
				HttpStatus.OK);
	}
	
	private int calculaAdicao(int maiorDivisor, int divisor) {
		int valor = ((maiorDivisor - divisor) / 2);
		if (valor == 0) {
			return 1;
		}
		return valor;
	}

}
