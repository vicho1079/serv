package com.fpyme.serv.controllers;

import com.fpyme.serv.model.dto.LoginRequest;
import com.fpyme.serv.model.dto.LoginResponse;
import com.fpyme.serv.model.entity.Producto;
import com.fpyme.serv.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;
    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest login){
        return  ResponseEntity
                .accepted()
                .body(LoginResponse.builder()
                        .accessToken("fsdfs")
                        .build());
    }
}
