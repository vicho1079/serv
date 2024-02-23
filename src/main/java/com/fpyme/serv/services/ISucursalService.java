package com.fpyme.serv.services;

import com.fpyme.serv.model.entity.Producto;
import com.fpyme.serv.model.entity.Sucursal;

import java.util.List;
import java.util.Optional;

public interface ISucursalService {
    Sucursal save(Sucursal sucursal);
    Optional<Sucursal> findById(Long id);
    void delete(Sucursal sucursal);
    boolean existsById(Long id);
    List<Sucursal> findAll();

}
