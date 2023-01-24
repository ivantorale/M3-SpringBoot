/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.torres.api.servicio;

import com.torres.api.modelo.Product;
import com.torres.api.repositorio.ProductRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author ivantorale
 */
@Service
public class ProductServicio {
    @Autowired
    private ProductRepositorio repositorio;
    
    public List<Product>listarProduct(){
        return repositorio.findAll();
    }
    
    public void guardarProduct(Product product){
        repositorio.save(product);
    }
    
    public Product obtenerProductPorId(Integer id){
        return repositorio.findById(id).get();
    }
    
    public void eliminarProduct(Integer id){
        repositorio.deleteById(id);
    }
}
