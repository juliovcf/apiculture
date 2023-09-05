package com.apiculture.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
