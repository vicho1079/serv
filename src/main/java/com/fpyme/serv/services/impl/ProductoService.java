package com.fpyme.serv.services.impl;

import com.fpyme.serv.model.dto.PostOferta;
import com.fpyme.serv.model.dto.PostProducto;
import com.fpyme.serv.model.dto.PutProducto;
import com.fpyme.serv.model.entity.Oferta;
import com.fpyme.serv.model.entity.Producto;
import com.fpyme.serv.repositories.OfertaRepository;
import com.fpyme.serv.repositories.ProductoRepository;
import com.fpyme.serv.services.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {
    private final ProductoRepository productoRepository;
    private final OfertaRepository ofertaRepository;

    @Override
    @Transactional
    public Producto saveProducto(PostProducto producto) {
        return productoRepository.save(PostProducto.toProducto(producto));
    }

    @Override
    public Producto updateProducto(PutProducto producto) {
        return productoRepository.save(PutProducto.toProducto(producto));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteProducto(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isPresent()){
            productoRepository.delete(producto.get());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean existsProductoById(Long id) {
        return productoRepository.existsById(id);
    }

    @Override
    @Transactional
    public Page<Producto> findAllProductos(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Optional<Oferta> saveOferta(Long prodId, PostOferta request) {
        Optional<Producto> producto = productoRepository.findById(prodId);
        if(producto.isPresent()){
            Oferta oferta = ofertaRepository.save(PostOferta.toOferta(request));
            Producto newProducto = producto.get();
            newProducto.setOferta(oferta);
            productoRepository.save(newProducto);
            return Optional.of(oferta);
        }
        return Optional.empty();

    }
}
