package br.com.integracorp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "tb_partner")
public class UnitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private Long unit;
	
	private String block;
	
	private String square;
	
	private String lot;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private PersonEntity person;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private PersonEntity client;
	
}
