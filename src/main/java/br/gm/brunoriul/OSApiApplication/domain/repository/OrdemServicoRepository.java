/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.gm.brunoriul.OSApiApplication.domain.repository;

import br.gm.brunoriul.OSApiApplication.domain.model.OrdemServico;
import br.gm.brunoriul.OSApiApplication.domain.model.StatusOrdemServico;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
    
    List<OrdemServico> findByClienteId(Long clienteID);
    
}
