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
@Table(name = "tb_sector")
public class SectorEntity
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		
		private Long unit;
		
		private String department;
		
		private String sector;
		
		@ManyToOne
		@JoinColumn(name = "client_id")
		private PersonEntity client;
}