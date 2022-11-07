package br.com.integracorp.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integracorp.entities.ClientEntity;
import br.com.integracorp.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<ClientEntity> findAll(){
		return clientRepository.findAll();
	}
	
	public ClientEntity findById(Long id)
	{
		Optional<ClientEntity> client =  clientRepository.findById(id);
		return client.orElse(null);
	}
	
	public ClientEntity save(ClientEntity client)
	{
		return clientRepository.save(client);
	}
	
	public void delete (Long id)
	{
		clientRepository.deleteById(id);
	}
	
	public ClientEntity update(Long id, ClientEntity client)
	{
		ClientEntity clientMonitored = clientRepository.getReferenceById(id);
		updateData(clientMonitored, client);
		return clientRepository.save(clientMonitored);
	}

	private void updateData(ClientEntity clientMonitored, ClientEntity client) {
		/*clientMonitored.setName(client.getName());
		clientMonitored.setDoc_rg(client.getDoc_rg());
		clientMonitored.setDoc_cpf(client.getDoc_cpf());
		clientMonitored.setBirthday(client.getBirthday());
		clientMonitored.setContact_1(client.getContact_1());
		clientMonitored.setContact_2(client.getContact_2());
		clientMonitored.setContact_3(client.getContact_3());
		clientMonitored.setEmail(client.getEmail());
		*/
	}
	
	
}
