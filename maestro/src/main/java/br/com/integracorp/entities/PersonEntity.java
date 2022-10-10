package br.com.integracorp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_person")
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String doc_rg;
	private String doc_cpf;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	@ManyToMany
	@JoinTable(name="tb_person_contact",
				joinColumns = @JoinColumn(name="person_id"),
				inverseJoinColumns = @JoinColumn(name="contact_id"))
	private Set<ContactEntity> contacts = new HashSet<>();

	@OneToOne(mappedBy = "person")
	private ClientEntity client;
	
	private String email;
}
