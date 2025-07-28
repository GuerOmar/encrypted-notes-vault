package com.notesvault.application.port.in;

import com.notesvault.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ManageUserUseCase extends UserDetailsService {
    User createUser(String username, String password);
}
