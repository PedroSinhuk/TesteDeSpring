package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping ("/boasvindas")
    public String BoasVindas(){
        return "Essa é minha primeira rota";
    }

}
