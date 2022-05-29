package br.ueg.Carro.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.Carro.model.Carro;
import br.ueg.Carro.repositoy.CarroRepository;

@RestController
@RequestMapping(path = "/Carro")
public class CarroController {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@GetMapping
	public List<Carro> listar(){
		Iterable<Carro> findAll = carroRepository.findAll();
		List<Carro> carros= new ArrayList<Carro>();
		findAll.forEach(carro -> {
			carros.add(carro);
		});
		//List<Carro> carros = new ArrayList<Carro>();
		//carros.add(new Carro(1,"Astra","Chevrolet",2010,1067));
		//carros.add(new Carro(2,"Cruise","Chevrolet",2013,106));
		//carros.add(new Carro(3,"Gol","Volkswagen",2018,1069));
		return carros;
		
	}
	@PostMapping
	public Carro incluir(@RequestBody Carro carro) {
		return carroRepository.save(carro);
		
	}
	
	@PostMapping(path = "/{id}")
	public Carro alterar(@RequestBody Carro carro, @RequestParam Long id){
		Optional<Carro> carroBD = carroRepository.findById(id);
		if(!carroBD.isPresent()) {
			throw new IllegalStateException("Carro não existe para ID:"+id);
			
		}
		Carro carroOld = carroBD.get();
		
		if(carro.getAno()!=null) {
			carroOld.setAno(carro.getAno());
		}
		if(carro.getMarca()!=null) {
			carroOld.setMarca(carro.getMarca());
		}
		if(carro.getModelo()!=null) {
			carroOld.setModelo(carro.getModelo());
		}
		
		return carroOld;
	}
	
	
}



