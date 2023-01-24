/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.torres.api.repositorio;

import com.torres.api.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ivantorale
 */
public interface ProductRepositorio extends JpaRepository<Product, Integer>{
    
}
