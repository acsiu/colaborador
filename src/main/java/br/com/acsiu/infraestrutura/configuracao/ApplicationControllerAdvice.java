package br.com.acsiu.infraestrutura.configuracao;

import br.com.acsiu.dominio.exceptions.MessageError;
import br.com.acsiu.dominio.exceptions.RegistroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException ex, final WebRequest request) {
        return new ResponseEntity<>(getMessage(ex, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RegistroNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNotFoundException(final RegistroNotFoundException ex, final WebRequest request) {
        return new ResponseEntity<>(getMessage(ex, String.valueOf(HttpStatus.NOT_FOUND.value())), HttpStatus.NOT_FOUND);
    }
    private static MessageError getMessage(Exception e, String codigo) {
        MessageError error = new MessageError();
        error.setCodigo(codigo);
        error.setMensagem(e.getMessage());
        return error;
    }
}
