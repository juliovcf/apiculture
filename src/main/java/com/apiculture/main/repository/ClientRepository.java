package com.apiculture.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
