package com.fpyme.serv.model.dto;
import com.fpyme.serv.model.entity.Producto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ProductoDto implements Serializable {

    private Long id_prod;
    private String nombre_prod;
    private int precio;
    private String estado;
    private String imagen;
    private String descripcion;

    public Producto aProducto(){
        return Producto.builder()
                .id_prod(id_prod)
                .nombre_prod(nombre_prod)
                .precio(precio)
                .estado(estado)
                .imagen(imagen)
                .descripcion(descripcion)
                .build();
    }
}
