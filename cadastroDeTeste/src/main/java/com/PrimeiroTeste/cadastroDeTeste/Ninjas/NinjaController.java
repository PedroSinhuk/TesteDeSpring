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
        public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar NINJA (READ)
    @GetMapping ("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping ("/listar/{id}")
    public NinjaDTO listarNinjasPorID(@PathVariable Long id){
        return ninjaService.listarNinjaPorID(id);
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterarID{id}")
    public NinjaDTO alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinjaPorID(id, ninjaAtualizado);
        }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorID(id);
    }

}
