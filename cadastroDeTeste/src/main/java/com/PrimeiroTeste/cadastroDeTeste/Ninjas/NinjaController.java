package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping ("/boasvindas")
    public String BoasVindas(){
        return "Essa é minha primeira rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/Criar")
        public String criarNinja(){
        return "Ninja Criado";
    }

    // Mostrar NINJA por ID (READ)
    @GetMapping ("/todos")
    public String mostrarTodosNinjas(){
        return "Mostrar ninjas:";
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping ("/todosID")
    public String mostrarNinjaID(){
        return "Mostrar Ninja por ID";
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Alterar Ninja por ID";
        }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Ninja deletado por ID";
    }

}
