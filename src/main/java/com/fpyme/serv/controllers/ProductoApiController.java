package com.fpyme.serv.controllers;

import com.fpyme.serv.model.entity.Producto;
import com.fpyme.serv.model.payload.MensajeResponse;
import com.fpyme.serv.services.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductoApiController {
    private final IProductoService productoService;

    public ProductoApiController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto createProducto(@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto, @PathVariable Long id){
        if(productoService.existsById(id) && producto.getId_prod().equals(id)){
            return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound()
                .build();
    }

    @DeleteMapping("/producto/{id}")
    //Investigar que significa el question mark en los tipos
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        Optional<Producto> producto = productoService.findById(id);
        if(producto.isPresent()){
            productoService.delete(producto.get());
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
    public ResponseEntity<?> showProductos(){
        List<Producto> productos =  productoService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

}
