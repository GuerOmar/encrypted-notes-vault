package com.notesvault.application.service;

import com.notesvault.application.port.in.ManageUserUseCase;
import com.notesvault.application.port.out.UserPersistencePort;
import com.notesvault.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ManageUserUseCase {

    private final UserPersistencePort userPersistencePort;

    public UserService(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userPersistencePort.loadUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    @Override
    public User createUser(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        userPersistencePort.save(user);
        return user;
    }
}
