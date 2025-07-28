package com.notesvault.application.port.out;

import com.notesvault.domain.User;

import java.util.Optional;

public interface UserPersistencePort {
    void save(User user);
    Optional<User> loadUserByUsername(String username);
}
