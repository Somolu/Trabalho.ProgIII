package br.ueg.Carro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
 @Table(name = "TBL_Carro")
public @Data class Carro {
	@Id
	@SequenceGenerator(
			name = "carro_sequence",
			sequenceName = "carro_sequence",
			allocationSize = 1,
			initialValue = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "carro_sequence"
			)
	
	@Column(name = "ID", nullable = false)
	long id;
	
	@Column(name ="Modelo", nullable = false, length = 100)
	String Modelo;
	
	@Column(name ="Marca", nullable = false, length = 100)
	String Marca;
	
	@Column(name ="Ano", nullable = false, length = 5)
	Integer Ano;
	
	@Column(name ="Chassi", nullable = false, length = 30, unique = true)
	Integer Chassi;
	
	
		

}
