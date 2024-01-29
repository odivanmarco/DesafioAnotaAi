package com.desafio.anota.ai.odivanmarcos.controllers;

import com.desafio.anota.ai.odivanmarcos.domain.products.Product;
import com.desafio.anota.ai.odivanmarcos.domain.products.ProductDto;
import com.desafio.anota.ai.odivanmarcos.services.interfaces.IProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final IProductService service;
    public ProductController(IProductService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDto dto){
        Product product = this.service.insert(dto);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDto dto){
        Product product = this.service.update(id, dto);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
