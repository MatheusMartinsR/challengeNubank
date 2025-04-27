package com.example.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nubank.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
