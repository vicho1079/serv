package com.fpyme.serv.services.impl;

import com.fpyme.serv.model.dto.AuthResponse;
import com.fpyme.serv.model.dto.LoginRequest;
import com.fpyme.serv.model.dto.RegisterRequest;
import com.fpyme.serv.model.entity.Role;
import com.fpyme.serv.model.entity.User;
import com.fpyme.serv.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request){
        User user = User.builder()
                .email(request.getEmail())
                .tel(request.getTel())
                .nombre_user(request.getNombre_user())
                .apellido_paterno(request.getApellido_paterno())
                .apellido_materno(request.getApellido_materno())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Role.USER)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
