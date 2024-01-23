package com.fpyme.serv.services;

import com.fpyme.serv.model.entity.Sucursal;
import com.fpyme.serv.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User save(User user);
    Optional<User> findById(Long id);
    void delete(User user);
    boolean existsById(Long id);
    List<User> findAll();
}
