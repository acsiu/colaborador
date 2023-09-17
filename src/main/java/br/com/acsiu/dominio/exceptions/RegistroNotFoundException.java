package br.com.acsiu.dominio.exceptions;

public class RegistroNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegistroNotFoundException(String mensagem) {
        super(mensagem);
    }
}
