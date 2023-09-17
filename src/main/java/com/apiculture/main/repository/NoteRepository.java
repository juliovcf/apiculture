package com.apiculture.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Note;
import com.apiculture.main.model.Status;

public interface NoteRepository extends JpaRepository<Note, Long> {

  public List<Note> findByStatus(Status status);

  public List<Note> findByClient(Client client);

}
