package com.fpyme.serv.repositories;

import com.fpyme.serv.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {
}
