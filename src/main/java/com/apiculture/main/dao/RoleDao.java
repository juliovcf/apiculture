package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Role;

public interface RoleDao {

  Role create(Role role);

  List<Role> findAll();

  Optional<Role> findById(Short id);

  Role update(Short id, Role role);

  int delete(Short id);
}
