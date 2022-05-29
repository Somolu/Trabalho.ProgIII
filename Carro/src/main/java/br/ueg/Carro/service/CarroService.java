package br.ueg.Carro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.ueg.Carro.model.Carro;
import br.ueg.Carro.repositoy.CarroRepository;

;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public Carro inserir(Carro carro) {
		boolean existeChassi = carroRepository.existeChassi(carro.getChassi());
		
		if(existeChassi) {
			throw new IllegalStateException("Um Carro com o Chassi: " + carro.getChassi() + "já existe!");
		}
		
		return carroRepository.save(carro);
	}
	
	public Carro getCarro(Integer chassi) {
		this.verificarSeExiste(chassi);
		Carro carro = obterCarro(chassi);
		return carro;
	}
	
	public List<Carro> listarTudo(){
		return carroRepository.findAll();
	}
	
	public List<Carro> getByMarca(String marca){
		List<Carro> carros = carroRepository.findByMarca(marca);
		if(CollectionUtils.isEmpty(carros)) {
			throw new IllegalAccessError("Não há carros do marca "+marca+" no sistema");
		}
		return carros;
	}
	
	public Carro remover(Integer chassi) {
		verificarSeExiste(chassi);
		Carro carro = obterCarro(chassi);
		carroRepository.delete(carro);		
		return carro;
	}
	
	public Carro alterar(Carro carro, Integer chassi) {
		verificarSeExiste(chassi);
		Carro carroBD = obterCarro(chassi);
		
		if(carro.getAno() != null) {
			carroBD.setAno(carro.getAno());
		}
		
		if(carro.getChassi() != null) {
			carroBD.setChassi(carro.getChassi());
		}
		
		if(StringUtils.hasLength(carro.getModelo())) {
			carroBD.setModelo(carro.getModelo());
		}
		
		if(StringUtils.hasLength(carro.getMarca())) {
			carroBD.setMarca(carro.getMarca());
		}
		
		carroBD = carroRepository.save(carroBD);		
		return carroBD;
	}
	
	private void verificarSeExiste(Integer chassi) {
		if(!carroRepository.existeChassi(chassi)) {
			throw new IllegalStateException("Não existe um carro com o Chassi: " + chassi);
		}
	}
	
	private Carro obterCarro(Integer chassi){
		return carroRepository.findByChassi(chassi);
	}
	
}

