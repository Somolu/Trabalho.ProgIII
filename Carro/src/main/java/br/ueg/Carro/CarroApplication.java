package br.ueg.Carro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ueg.Carro.model.Carro;
import br.ueg.Carro.repositoy.CarroRepository;

@SpringBootApplication
public class CarroApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CarroApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(CarroRepository repository) {
		return args -> {
			Carro a1 = new Carro(4,"Fusca","Volkswagen",1994,1098);
			repository.save(a1);
			a1 = new Carro(12,"Monza","Cabuloso",1999,6666);
			repository.save(a1);
		};
		
	}
}
