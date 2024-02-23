package com.fpyme.serv.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
@Data
public class User implements UserDetails {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(nullable = false, name = "nombre_user")
    private String nombre_user;

    @Column(nullable = false, name = "apellido_paterno_user")
    private String apellido_paterno;

    @Column(nullable = false, name = "apellido_materno")
    private String apellido_materno;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "tel")
    private String tel;

    @Column(nullable = false, name = "password")
    @JsonIgnore
    private String password;

    @Column(nullable = true, name = "imagen_perfil")
    private String imagen_perfil;

    @Column(nullable = false, name = "rol")
    @Enumerated(EnumType.STRING)
    private Role rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }
    @Override
    public String getUsername() {
        return email;
    }

    /*Todo lo de abajo queda como true, ya que los componentes que se va a encargar de cumplir esa funcionalidad son
    los componentes JWT.*/
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
