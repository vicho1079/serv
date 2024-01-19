package com.fpyme.serv.repositories;

import com.fpyme.serv.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {}
