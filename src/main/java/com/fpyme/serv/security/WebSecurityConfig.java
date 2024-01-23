package com.fpyme.serv.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// tutorial https://www.youtube.com/watch?v=mPHbM6o8bk8&list=PLVuqGBBX_tP3KmownF68ifFmgPQt-ujBg&index=2
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable) //revisar notas de desarrollo
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .securityMatcher("/**") // la seguridad es para toda la app usando /**
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/").permitAll() // todos son permitidos en la ruta /
                        .requestMatchers("/auth/login").permitAll()
                        .anyRequest().authenticated()) //los demas se tienen que autenticar
                .build();

    }
}
