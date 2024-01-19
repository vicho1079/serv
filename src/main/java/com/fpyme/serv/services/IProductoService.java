package com.fpyme.serv.services;

import com.fpyme.serv.model.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService{
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
    void delete(Producto producto);
    boolean existsById(Long id);

    List<Producto> findAll();

}
