package br.gm.brunoriul.OSApiApplication.domain.service;

import br.gm.brunoriul.OSApiApplication.domain.exception.DomainException;
import br.gm.brunoriul.OSApiApplication.domain.model.OrdemServico;
import br.gm.brunoriul.OSApiApplication.domain.model.StatusOrdemServico;
import br.gm.brunoriul.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import java.util.Optional;
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
    
    
    
    public Optional<OrdemServico> atualizaStatus(Long ordemServicoID, StatusOrdemServico status) {
        
        Optional<OrdemServico> optOrdemServico = ordemServicoRepository.findById(ordemServicoID);
        
        if (optOrdemServico.isPresent()) {
            
            OrdemServico ordemServico = optOrdemServico.get();
            
            //Verifica se a ordem está aberta
            if (ordemServico.getStatus()==StatusOrdemServico.ABERTA && status != StatusOrdemServico.ABERTA) {
            ordemServico.setStatus(status);
            ordemServico.setDataFinalizacao(LocalDateTime.now());
            ordemServicoRepository.save(ordemServico);
            return Optional.of(ordemServico);
            
            }else {
                return Optional.empty(); 
            }
        }else{
            throw new DomainException("Não existe OS com o ID '" + ordemServicoID + "'");
        }
        
    }
    
}
