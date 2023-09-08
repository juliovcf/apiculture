package com.apiculture.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Role;
import com.apiculture.main.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  public List<User> findByRole(Role role);

}
