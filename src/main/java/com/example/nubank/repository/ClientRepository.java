package com.example.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nubank.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

}
