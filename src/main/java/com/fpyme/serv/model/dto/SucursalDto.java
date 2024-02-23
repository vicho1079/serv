package com.fpyme.serv.model.dto;
import com.fpyme.serv.model.entity.Sucursal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data


public class SucursalDto {

    private Long id_suc;
    private String nombre_suc;
    private String direccion;
    private String imagen;
    private String email;
    private String telefono;

    public Sucursal aSucursal(){
        return Sucursal.builder()
                .id_suc(id_suc)
                .nombre_suc(nombre_suc)
                .direccion(direccion)
                .imagen(imagen)
                .email(email)
                .telefono(telefono)
                .build();
    }
}
