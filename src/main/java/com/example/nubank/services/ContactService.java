package com.example.nubank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nubank.dto.ContactDTO;
import com.example.nubank.models.Client;
import com.example.nubank.models.Contact;
import com.example.nubank.repository.ClientRepository;
import com.example.nubank.repository.ContactRepository;

@Service
public class ContactService {

  @Autowired
  private ContactRepository contactRepository;

  @Autowired
  private ClientRepository clientRepository;

  public Contact insertContact(ContactDTO contactDTO, Long clientId) {
    Contact contact = new Contact();
    contact.setContact_name(contactDTO.getContact_name());
    contact.setContact_number(contactDTO.getContact_number());

    Client client = clientRepository.findById(clientId)
        .orElseThrow(() -> new RuntimeException("Client with this id not found: " + clientId));

    contact.setClient(client);

    return contactRepository.save(contact);
  }

  public void deleteContact(Long id) {
    if (contactRepository.existsById(id)) {
      contactRepository.deleteById(id);
    } else {
      throw new RuntimeException("Contact with this id not founded" + id);
    }
  }

  public List<Contact> getAllContacts() {
    return contactRepository.findAll();
  }

  public Contact getContactById(Long id) {
    return contactRepository.findById(id).orElse(null);
  }
}
