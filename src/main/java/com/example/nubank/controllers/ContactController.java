package com.example.nubank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nubank.models.Contact;
import com.example.nubank.repository.ContactRepository;

@RestController
@RequestMapping("/contacts")
public class ContactController {

  @Autowired
  private ContactRepository contactRepository;

  @GetMapping
  public List<Contact> getAllContacts() {
    return contactRepository.findAll();
  }

}
