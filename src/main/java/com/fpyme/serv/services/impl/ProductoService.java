package com.fpyme.serv.services.impl;

import com.fpyme.serv.model.entity.Producto;
import com.fpyme.serv.repositories.ProductoCrudRepository;
import com.fpyme.serv.services.IProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    private final ProductoCrudRepository productoCrudRepository;

    public ProductoService(ProductoCrudRepository productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        return productoCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoCrudRepository.delete(producto);
    }

    @Override
    @Transactional
    public boolean existsById(Long id) {
        return productoCrudRepository.existsById(id);
    }

    @Override
    public List<Producto> findAll() {
        return (List) productoCrudRepository.findAll();
    }
}
