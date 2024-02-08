package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.apiculture.main.dao.RoleDao;
import com.apiculture.main.model.Role;
import com.apiculture.main.repository.RoleRepository;

@Repository
public class RoleDaoImpl implements RoleDao {

  @Autowired
  RoleRepository roleRepository;

  @SuppressWarnings("null")
  @Override
  public Role create(Role role) {
    return roleRepository.save(role);
  }

  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }

  @SuppressWarnings("null")
  @Override
  public Optional<Role> findById(Short id) {
    return roleRepository.findById(id);
  }

  @Override
  public Role update(Short id, Role role) {
    role.setId(id);
    return roleRepository.save(role);
  }

  @SuppressWarnings("null")
  @Override
  public int delete(Short id) {
    try {
      roleRepository.deleteById(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception ex) {
      return -1; // Ocurrió un error inesperado
    }
  }

}
