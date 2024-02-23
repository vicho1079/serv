package com.fpyme.serv.services;

import com.fpyme.serv.model.dto.PostOferta;
import com.fpyme.serv.model.dto.PostProducto;
import com.fpyme.serv.model.dto.PutProducto;
import com.fpyme.serv.model.entity.Oferta;
import com.fpyme.serv.model.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IProductoService{
    Producto saveProducto(PostProducto producto);
    Producto updateProducto(PutProducto producto);
    Optional<Producto> findById(Long id);
    boolean deleteProducto(Long id);
    boolean existsProductoById(Long id);
    Page<Producto> findAllProductos(Pageable pageable);
    Optional<Oferta> saveOferta(Long prodId, PostOferta oferta);
}
