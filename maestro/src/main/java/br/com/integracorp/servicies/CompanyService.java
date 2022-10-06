package br.com.integracorp.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integracorp.entities.CompanyEntity;
import br.com.integracorp.repositories.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<CompanyEntity> findAll(){
		return companyRepository.findAll();
	}
	
	public CompanyEntity findById(Long id)
	{
		Optional<CompanyEntity> company =  companyRepository.findById(id);
		return company.orElse(null);
	}
	
	public CompanyEntity save(CompanyEntity company)
	{
		return companyRepository.save(company);
	}
	
	public void delete (Long id)
	{
		companyRepository.deleteById(id);
	}
	
	public CompanyEntity update(Long id, CompanyEntity company)
	{
		CompanyEntity companyMonitored = companyRepository.getReferenceById(id);
		updateData(companyMonitored, company);
		return companyRepository.save(companyMonitored);
	}

	private void updateData(CompanyEntity companyMonitored, CompanyEntity company) {
		companyMonitored.setCompany_name(company.getCompany_name());
		companyMonitored.setDoc_cnpj(company.getDoc_cnpj());
		companyMonitored.setDoc_inscricao_estadual(company.getDoc_inscricao_estadual());
		companyMonitored.setCompany_start(company.getCompany_start());
		companyMonitored.setContact_1(company.getContact_1());
		companyMonitored.setContact_2(company.getContact_2());
		companyMonitored.setContact_3(company.getContact_3());
		companyMonitored.setEmail(company.getEmail());
	}
	
	
}
