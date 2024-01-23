package com.fpyme.serv.services.impl;

import com.fpyme.serv.model.entity.User;
import com.fpyme.serv.repositories.UserCrudRepository;
import com.fpyme.serv.services.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserCrudRepository userCrudRepository;

    public UserService(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    @Transactional
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    @Override
    @Transactional
    public boolean existsById(Long id) {
        return userCrudRepository.existsById(id);
    }

    @Override
    public List<User> findAll() {
        return (List) userCrudRepository.findAll();
    }
}
