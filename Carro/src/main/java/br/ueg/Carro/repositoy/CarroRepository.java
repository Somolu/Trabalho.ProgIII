package br.ueg.Carro.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ueg.Carro.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
	List<Carro> findByMarca(String Marca);
	
	Carro findByChassi(Integer chassi);
	
	@Query("" +
            "SELECT CASE WHEN COUNT(f) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Carro f " +
            "WHERE f.chassi = ?1"
    )
    Boolean existeChassi(Integer chassi);
}
