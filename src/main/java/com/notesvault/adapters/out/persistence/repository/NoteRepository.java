package com.notesvault.adapters.out.persistence.repository;

import com.notesvault.adapters.out.persistence.entity.NoteJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<NoteJpa, UUID> {
    @Query("Select n from NoteJpa n where userId = :userId")
    List<NoteJpa> findByOwnerId(@Param("userId") UUID ownerId);
}
