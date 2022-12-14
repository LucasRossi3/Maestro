package br.com.integracorp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_partner")
public class PartnerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String partner_id;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private CompanyEntity company;
	
	@JsonIgnore
	@OneToMany(mappedBy = "partner", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<ClientEntity> partner = new HashSet<>();
	
}
