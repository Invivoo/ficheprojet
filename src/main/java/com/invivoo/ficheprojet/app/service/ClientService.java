package com.invivoo.ficheprojet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invivoo.ficheprojet.app.domain.Client;
import com.invivoo.ficheprojet.app.repository.ClientRepository;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> list() {
	return clientRepository.findAll();
    }

    public Client save(Client client) {
	return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Client read(Long id) {
	return clientRepository.findOne(id);
    }

    public void delete(Long id) {
	clientRepository.delete(id);
    }
}
