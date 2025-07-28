package com.notesvault.adapters.out.persistence;

import com.notesvault.adapters.out.persistence.entity.UserJpa;
import com.notesvault.adapters.out.persistence.repository.UserRepository;
import com.notesvault.application.port.out.UserPersistencePort;
import com.notesvault.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository repository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.repository = userRepository;
    }


    @Override
    public void save(User user) {
        UserJpa userJpa = UserJpa.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        repository.save(userJpa);
    }

    @Override
    public Optional<User> loadUserByUsername(String username) {
        return repository.findByUsername(username).map(
                userJpa -> User.builder()
                        .id(userJpa.getId())
                        .username(userJpa.getUsername())
                        .password(userJpa.getPassword())
                        .build());
    }
}
