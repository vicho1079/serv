package com.fpyme.serv.model.dto;
import com.fpyme.serv.model.entity.EstadoProducto;
import com.fpyme.serv.model.entity.Producto;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class PostProducto implements Serializable {

    private String nombreProd;
    private int precio;
    private EstadoProducto estado;
    private String imagen;
    private String descripcion;

    public static Producto toProducto(PostProducto request){
        return Producto.builder()
                .nombreProd(request.nombreProd)
                .precio(request.precio)
                .estado(request.estado)
                .imagen(request.imagen)
                .descripcion(request.descripcion)
                .build();
    }
}
