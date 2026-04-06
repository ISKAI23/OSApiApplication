package br.gm.brunoriul.OSApiApplication.domain.service;

import br.gm.brunoriul.OSApiApplication.domain.model.OrdemServico;
import br.gm.brunoriul.OSApiApplication.domain.model.StatusOrdemServico;
import br.gm.brunoriul.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */

@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico criar(OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        return ordemServicoRepository.save(ordemServico);
    }
    
    public void excluir(Long ordemServicoID){
        ordemServicoRepository.deleteById(ordemServicoID);
    }
    
}
