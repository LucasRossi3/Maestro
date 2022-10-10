package br.com.integracorp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.integracorp.entities.enums.CompanyType;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_company")
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String company_name;
	@Column(nullable = false)
	private String trading_name;
	private String doc_cnpj;
	private String doc_inscricao_estadual;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date company_start;
	private CompanyType company_type;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<PartnerEntity> partner = new HashSet<>();
	
	@OneToOne(mappedBy = "company")
	private ClientEntity clinte;
	
	@ManyToMany
	@JoinTable(name="tb_company_contact",
				joinColumns = @JoinColumn(name="company_id"),
				inverseJoinColumns = @JoinColumn(name="contact_id"))
	private Set<ContactEntity> contacts = new HashSet<>();
}
