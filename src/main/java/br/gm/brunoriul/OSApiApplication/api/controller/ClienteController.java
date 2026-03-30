/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.OSApiApplication.api.controller;

import br.gm.brunoriul.OSApiApplication.domain.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/cliente")
    public List<Cliente> listas() {    
        
        return manager.createQuery("from Cliente", Cliente.class).getResultList();
    }

}
