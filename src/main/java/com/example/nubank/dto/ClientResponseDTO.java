package com.example.nubank.dto;

import java.util.List;

import lombok.Data;

@Data
public class ClientResponseDTO {

  private Long id;
  private String username;
  private String email;
  private List<ContactDTO> contacts;

}
