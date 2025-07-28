package com.notesvault.adapters.in.web;

import com.notesvault.adapters.in.web.dto.AuthRequest;
import com.notesvault.application.port.in.ManageUserUseCase;
import com.notesvault.domain.User;
import com.notesvault.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final ManageUserUseCase manageUserUseCase;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, ManageUserUseCase manageUserUseCase, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.manageUserUseCase = manageUserUseCase;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AuthRequest request) {
        User user = manageUserUseCase.createUser(request.username(), passwordEncoder.encode(request.password()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        String token = jwtTokenProvider.generateToken(request.username());
        return ResponseEntity.ok(token);
    }
}
