package com.fpyme.serv.model.entity;
import com.fpyme.serv.model.dto.ProductoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "producto")
@Data


public class Producto {
    @Id
    @Column(name = "id_prod")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prod;

    @Column(nullable = false, name = "nombre_prod")
    private String nombre_prod;

    @Column(nullable = false, name = "precio")
    private int precio;

    @Column(nullable = false, name = "estado")
    private String estado;

    @Column(nullable = false, name = "imagen")
    private String imagen;

    @Column(nullable = false, name = "descripcion")
    private String descripcion;

    public ProductoDto aProductoDto(){
        return ProductoDto.builder()
                .id_prod(id_prod)
                .nombre_prod(nombre_prod)
                .precio(precio)
                 .imagen(imagen)
                .descripcion(descripcion)
                .build();
    }
}
