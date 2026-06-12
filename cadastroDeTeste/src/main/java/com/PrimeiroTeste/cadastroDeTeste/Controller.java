package com.PrimeiroTeste.cadastroDeTeste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ser.jdk.JDKArraySerializers;

@RestController
@RequestMapping
public class Controller {

    @GetMapping ("/boasvindas")
    public String BoasVindas(){
        return "Essa é minha primeira rota";
    }

}
