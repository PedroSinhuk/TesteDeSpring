package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping ("/boasvindas")
    public String BoasVindas(){
        return "Essa é minha primeira rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
        public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel){
        return ninjaService.criarNinja(ninjaModel);
    }

    // Mostrar NINJA por ID (READ)
    @GetMapping ("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping ("/listar/{id}")
    public NinjaModel listarNinjasPorID(@PathVariable Long id){
        return ninjaService.listarNinjaPorID(id);
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
