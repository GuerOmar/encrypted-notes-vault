package com.notesvault.adapters.out.persistence.repository;

import com.notesvault.adapters.out.persistence.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserJpa, UUID> {
    @Query("select u from UserJpa u where username = :username")
    Optional<UserJpa> findByUsername(@Param("username") String username);
}
