package com.fpyme.serv.model.payload;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MensajeResponse {
    String mensaje;
    Object objecto;
}
