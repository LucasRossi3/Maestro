package br.com.integracorp.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integracorp.entities.CompanyEntity;
import br.com.integracorp.entities.PartnerEntity;
import br.com.integracorp.repositories.CompanyRepository;
import br.com.integracorp.repositories.PartnerRepository;

@Service
public class PartnerService {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	
	public List<PartnerEntity> findAll(){
		return partnerRepository.findAll();
	}
	
	public PartnerEntity findById(Long id)
	{
		Optional<PartnerEntity> partner =  partnerRepository.findById(id);
		return partner.orElse(null);
	}
	
	public PartnerEntity save(PartnerEntity partner)
	{
		return partnerRepository.save(partner);
	}
	
	public void delete (Long id)
	{
		partnerRepository.deleteById(id);
	}
	
	public PartnerEntity update(Long id, PartnerEntity partner)
	{
		PartnerEntity partnerMonitored = partnerRepository.getReferenceById(id);
		updateData(partnerMonitored, partner);
		return partnerRepository.save(partnerMonitored);
	}

	private void updateData(PartnerEntity partnerMonitored, PartnerEntity partner) {
		partnerMonitored.setPartner_id(partner.getPartner_id());
		partnerMonitored.setCompany(partner.getCompany());
	}
	
	
}
