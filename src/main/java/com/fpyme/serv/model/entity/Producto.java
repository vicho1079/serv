package com.fpyme.serv.model.entity;
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
    private Long idProd;

    @Column(nullable = false, name = "nombre_prod")
    private String nombreProd;

    @Column(nullable = false, name = "precio")
    private int precio;

    @Column(nullable = false, name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoProducto estado;

    @Column(nullable = false, name = "imagen")
    private String imagen;

    @Column(nullable = false, name = "descripcion")
    private String descripcion;

    @OneToOne(targetEntity = Oferta.class, cascade = CascadeType.ALL)
    // ver despues que se elige como cascade. Evaluar mejor el tipo de relacion que se quiere.
    @JoinColumn(name = "id_oferta", unique = true)
    private Oferta oferta;

}
