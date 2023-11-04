package com.apiculture.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Nationality;

public interface NationalityRepository extends JpaRepository<Nationality, Integer> {

}
