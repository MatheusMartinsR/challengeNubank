package com.example.nubank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nubank.dto.ClientDTO;
import com.example.nubank.models.Client;
import com.example.nubank.models.Contact;
import com.example.nubank.repository.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public Client insertClient(ClientDTO clientDTO) {

    Client client = new Client();
    client.setUsername(clientDTO.getUsername());
    client.setEmail(clientDTO.getEmail());

    if (clientDTO.getContacts() != null) {
      List<Contact> contacts = clientDTO.getContacts().stream().map(contactDTO -> {
        Contact contact = new Contact();
        contact.setContact_name(contactDTO.getContact_name());
        contact.setContact_number(contactDTO.getContact_number());
        contact.setClient(client);
        return contact;
      })
          .toList();

      client.setContacts(contacts);
    }

    return clientRepository.save(client);

  }

  public void deleteClient(Long id) {
    if (clientRepository.existsById(id)) {
      clientRepository.deleteById(id);
    } else {
      throw new RuntimeException("client with this id not founded" + id);
    }
  }

  public List<Client> getAllClient() {
    return clientRepository.findAll();
  }

  public Client getClientById(Long id) {
    return clientRepository.findById(id).orElse(null);
  }

}
