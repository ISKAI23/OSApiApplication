package br.gm.brunoriul.OSApiApplication.domain.exception;

import br.gm.brunoriul.OSApiApplication.api.exceptionhandler.ProblemaException;
import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/**
 *
 * @author digma
 */
public class DomainException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public DomainException(String message){
        super (message);
    }
}
