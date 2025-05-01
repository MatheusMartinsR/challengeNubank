package com.example.nubank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nubank.dto.ContactDTO;
import com.example.nubank.models.Contact;
import com.example.nubank.repository.ContactRepository;
import com.example.nubank.services.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

  @Autowired
  private ContactRepository contactRepository;

  @Autowired
  private ContactService contactService;

  @GetMapping
  public List<Contact> getAllContacts() {
    return contactRepository.findAll();
  }

}
