package com.example.nubank.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nubank.dto.ClientDTO;
import com.example.nubank.dto.ClientResponseDTO;
import com.example.nubank.dto.ContactDTO;
import com.example.nubank.models.Client;
import com.example.nubank.models.Contact;
import com.example.nubank.repository.ClientRepository;
import com.example.nubank.services.ClientService;
import com.example.nubank.services.ContactService;

@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private ContactService contactService;

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping
  @ResponseBody
  public List<Client> getAllClient() {
    return clientRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<ClientResponseDTO> insertClient(@RequestBody ClientDTO clientDTO) {
    Client client = clientService.insertClient(clientDTO);

    ClientResponseDTO dto = new ClientResponseDTO();

    dto.setId(client.getId());
    dto.setUsername(client.getUsername());
    dto.setEmail(client.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }

  @PostMapping("/{clientId}/contacts")
  public ResponseEntity<Contact> addContactToClient(@PathVariable Long clientId, @RequestBody ContactDTO contactDTO) {
    Contact savedContact = contactService.insertContact(contactDTO, clientId);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteClient(@PathVariable Long id) {
    try {
      clientService.deleteClient(id);
      return ResponseEntity.ok("deleted with sucess");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable Long id) {
    Client client = clientService.getClientById(id);
    if (client != null) {
      return ResponseEntity.ok(client);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

}
