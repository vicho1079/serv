package com.fpyme.serv.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component // para que sea manejado por spring
@RequiredArgsConstructor
public class JwtIssuer {
    private final JwtProperties properties;
    public String issue(Long idUser, String email, String rol){
        return JWT.create()
                .withSubject(idUser.toString())
                .withClaim("e", email)
                .withClaim("r", rol)
                .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS))) //cambiar luego a 5 minutos aprox
                .sign(Algorithm.HMAC256(properties.getSecretKey()));
    }
}
