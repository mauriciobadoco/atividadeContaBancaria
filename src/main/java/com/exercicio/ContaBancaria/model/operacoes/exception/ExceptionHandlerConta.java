package com.exercicio.ContaBancaria.model.operacoes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerConta extends ResponseEntityExceptionHandler {

    @Autowired
    //buscar a interface do Spring  que auxilia busca de mensagem no codigo
    MessageSource messageSource;
    //buscar o metodo do ResponseEntityExceptionHandler, handleHttpMessageNotReadble
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, null);
        String mensagemDev = ex.getCause().toString();
        return handleExceptionInternal(ex, new MensagemErro(mensagemUsuario, mensagemDev), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static  class MensagemErro{

        private String msgUsuario;
        private String msgDev;
    }


    /*
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String > exceptionHandlerCampoInvalido(HttpMessageNotReadableException
                                                                             exception, HttpServletRequest request){
        return new ResponseEntity<>("A entrada está incorreta", HttpStatus.BAD_REQUEST);

    }*/

}
