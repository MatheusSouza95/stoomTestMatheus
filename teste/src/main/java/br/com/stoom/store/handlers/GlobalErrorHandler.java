package br.com.stoom.store.handlers;

import br.com.stoom.store.dto.MessageDTO;
import br.com.stoom.store.exceptions.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<MessageDTO> handleDataNotFoundExceptions(Exception e, WebRequest request) {
        logger.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageDTO(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

}
