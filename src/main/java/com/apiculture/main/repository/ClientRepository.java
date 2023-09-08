package com.apiculture.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Status;

public interface ClientRepository extends JpaRepository<Client, Integer> {

  public List<Client> findByStatus(Status status);

}
