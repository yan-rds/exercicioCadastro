package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.exceptions.NaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(NaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro naoEncontradoException (NaoEncontradoException exception){
        return new MensagemDeErro(exception.getMessage());
    }

}
