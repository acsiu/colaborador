package br.com.acsiu.dominio.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageError {

    private String codigo;
    private String mensagem;
}