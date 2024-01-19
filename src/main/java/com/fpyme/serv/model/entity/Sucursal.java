package com.fpyme.serv.model.entity;
import com.fpyme.serv.model.dto.ProductoDto;
import com.fpyme.serv.model.dto.SucursalDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sucursal")
@Data


public class Sucursal {
    @Id
    @Column(name = "id_suc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_suc;

    @Column(nullable = false, name = "nombre_suc")
    private String nombre_suc;

    @Column(nullable = false, name = "direccion")
    private String direccion;

    @Column(nullable = false, name = "imagen")
    private String imagen;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "telefono")
    private String telefono;

    public SucursalDto aSucursalDto() {
        return SucursalDto.builder()
                .id_suc(id_suc)
                .nombre_suc(nombre_suc)
                .direccion(direccion)
                .imagen(imagen)
                .email(email)
                .telefono(telefono)
                .build();
    }
}
