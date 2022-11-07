package br.com.integracorp.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_contact")
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private String number;

	@JsonIgnore
	@ManyToMany(mappedBy = "contacts", cascade = CascadeType.ALL)
	private Set<PersonEntity> people = new HashSet<>(); 
	
	@JsonIgnore
	@ManyToMany(mappedBy = "contacts", cascade = CascadeType.ALL)
	private Set<CompanyEntity> companies = new HashSet<>(); 
	
}
