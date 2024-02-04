package com.fpyme.serv.model.dto;

import com.fpyme.serv.model.entity.EstadoProducto;
import com.fpyme.serv.model.entity.Producto;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class PutProducto implements Serializable {

    private Long idProd;
    private String nombreProd;
    private int precio;
    private EstadoProducto estado;
    private String imagen;
    private String descripcion;

    public static Producto toProducto(PutProducto request){
        return Producto.builder()
                .idProd(request.idProd)
                .nombreProd(request.nombreProd)
                .precio(request.precio)
                .estado(request.estado)
                .imagen(request.imagen)
                .descripcion(request.descripcion)
                .build();
    }
}

