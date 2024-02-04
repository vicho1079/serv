package com.fpyme.serv.controllers;

import com.fpyme.serv.model.dto.PostOferta;
import com.fpyme.serv.model.dto.PostProducto;
import com.fpyme.serv.model.dto.PutProducto;
import com.fpyme.serv.model.entity.Oferta;
import com.fpyme.serv.model.entity.Producto;
import com.fpyme.serv.model.payload.MensajeResponse;
import com.fpyme.serv.services.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductoApiController {
    private final IProductoService productoService;

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto createProducto(@RequestBody PostProducto producto){
        return productoService.saveProducto(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProducto(@RequestBody PutProducto producto, @PathVariable Long id){
        if(productoService.existsProductoById(id) && producto.getIdProd().equals(id)){
            return new ResponseEntity<>(productoService.updateProducto(producto), HttpStatus.OK);
        }
        return ResponseEntity.notFound()
                .build();
    }

    @DeleteMapping("/producto/{id}")
    //Investigar que significa el question mark en los tipos
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        if(productoService.deleteProducto(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            MensajeResponse response = MensajeResponse.builder()
                    .mensaje("ERROR: El elemento que intenta eliminar no existe")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> showProductoById(@PathVariable Long id){
        Optional<Producto> producto = productoService.findById(id);
        if(producto.isPresent()){
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound()
                .build();
    }

    @GetMapping("/productos")
    public ResponseEntity<?> showProductos(
            @RequestParam(value = "p", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "size", defaultValue = "10", required = false) int pageSize
    ){
        final Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Producto> productos =  productoService.findAllProductos(pageable);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @PostMapping("/oferta/{idProd}")
    public ResponseEntity<Oferta> createOferta(@PathVariable Long idProd, @RequestBody PostOferta request){
        String urlBase = "https://api.tuempresa.com/"; // crear un properties que tenga la url de la pagina.
        Optional<Oferta> oferta =  productoService.saveOferta(idProd, request);
        if(oferta.isPresent()){
            ResponseEntity.created(URI.create(urlBase))
                    .body(oferta.get());
        }
        return ResponseEntity.notFound()
                .build();
    }

}
