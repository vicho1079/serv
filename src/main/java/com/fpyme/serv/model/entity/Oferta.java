package com.fpyme.serv.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "oferta")
@Data
public class Oferta {
    @Id
    @Column(name = "id_oferta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOferta;
    @Column(nullable = false, name = "descuento")
    private float descuento;
    @Column(nullable = false, name = "precio_oferta")
    private int precioOferta;
    @Column(nullable = false, name = "fecha_inicio")
    private Date fechaInicio;
    @Column(nullable = false, name = "fecha_finalizacion")
    private Date fechaFinalizacion;

}
