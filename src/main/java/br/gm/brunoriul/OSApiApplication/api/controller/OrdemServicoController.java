/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.OSApiApplication.api.controller;

import br.gm.brunoriul.OSApiApplication.domain.model.Cliente;
import br.gm.brunoriul.OSApiApplication.domain.model.OrdemServico;
import br.gm.brunoriul.OSApiApplication.domain.repository.ClienteRepository;
import br.gm.brunoriul.OSApiApplication.domain.repository.OrdemServicoRepository;
import br.gm.brunoriul.OSApiApplication.domain.service.ClienteService;
import br.gm.brunoriul.OSApiApplication.domain.service.OrdemServicoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private OrdemServicoService ordemServicoService;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public List<OrdemServico> listas(){
        return ordemServicoRepository.findAll();
    }
    
    @GetMapping("/{ordemServicoID}")
    public ResponseEntity<OrdemServico> buscar(@PathVariable Long ordemServicoID){
        
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoID);
        
        if (ordemServico.isPresent()) {
            return ResponseEntity.ok(ordemServico.get());
        }
        
        else{
            return ResponseEntity.notFound().build();
        }
        
    }
    
    @GetMapping("/cliente/{clienteID}")
    public ResponseEntity<List<OrdemServico>> buscarCliente(@PathVariable Long clienteID) {

    Optional<Cliente> cliente = clienteRepository.findById(clienteID);

    if (cliente.isPresent()) {
        return ResponseEntity.ok(
            ordemServicoRepository.findByClienteId(clienteID)
        );
    } else {
        return ResponseEntity.notFound().build();
    }
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico){
        return ordemServicoService.criar(ordemServico);
    }
    
    @PutMapping("/{ordemServicoID}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable Long ordemServicoID, @RequestBody OrdemServico ordemServico) {
        
        if(!ordemServicoRepository.existsById(ordemServicoID)) {
            return ResponseEntity.notFound().build();
        }
        
        ordemServico.setId(ordemServicoID);
        ordemServico = ordemServicoService.criar(ordemServico);
        return ResponseEntity.ok(ordemServico);
        
    }

    @DeleteMapping("/{ordemServicoID}") //id
    public ResponseEntity<OrdemServico> excluir(@PathVariable Long ordemServicoID){
        //Verifica se o cliente existe
        if (!ordemServicoRepository.existsById(ordemServicoID)) {
            return ResponseEntity.notFound().build();
        }

        ordemServicoService.excluir(ordemServicoID);
        return ResponseEntity.noContent().build();
        
    }
    
    
}
