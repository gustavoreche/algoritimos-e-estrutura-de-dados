package reche.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Algoritmos E Estrutura De Dados",
				version = "10.0",
				description = "API para estudo de Algoritmos E Estrutura De Dados"
				)
		)
public class AlgoritmosEEstruturaDeDadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgoritmosEEstruturaDeDadosApplication.class, args);
	}

}
