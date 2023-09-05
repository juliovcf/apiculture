package com.apiculture.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Status;

public interface StatusRepository extends JpaRepository<Status, Short> {

}
