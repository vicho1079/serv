package com.fpyme.serv.model.dto;

import com.fpyme.serv.model.entity.Oferta;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PostOferta {
    private float descuento;
    private int precioOferta;
    private Date fechaInicio;
    private Date fechaFinalizacion;

    public static Oferta toOferta(PostOferta request){
        return Oferta.builder()
                .descuento(request.descuento)
                .precioOferta(request.precioOferta)
                .fechaInicio(request.fechaInicio)
                .fechaFinalizacion(request.fechaFinalizacion)
                .build();
    }
}
