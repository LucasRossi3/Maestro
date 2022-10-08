package br.com.integracorp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "tb_client")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="partner_id")
	private PartnerEntity partner;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	private CompanyEntity company;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private PersonEntity person;
	
}
