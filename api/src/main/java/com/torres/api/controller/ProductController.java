/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.torres.api.controller;

import com.torres.api.modelo.Product;
import com.torres.api.servicio.ProductServicio;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author ivantorale
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductServicio productServicio;
    
    @GetMapping("/Product")
    public List<Product> listarProduct(){
        return productServicio.listarProduct();
    }
    
    @GetMapping("/Product/{id}")    
    public ResponseEntity<Product> obtenerProduct(@PathVariable Integer id){
        try{
            Product product = productServicio.obtenerProductPorId(id);
            return ResponseEntity.ok(product);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/Product")
    public void nuevoProduct (@RequestBody Product product){
        productServicio.guardarProduct(product);
    }
    
    @PutMapping("/Product/{id}")
    public ResponseEntity<?> editarProduct (@RequestBody Product product, @PathVariable Integer id){
        try{
            Product productExistente = productServicio.obtenerProductPorId(id);
            productExistente.setName(product.getName());
            productExistente.setPrice(product.getPrice());
            productServicio.guardarProduct(productExistente);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    
    public void borrarProduct (@PathVariable Integer id){
        productServicio.eliminarProduct(id);
    }
}
