package com.apiculture.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Role;

public interface RoleRepository extends JpaRepository<Role, Short> {

}
