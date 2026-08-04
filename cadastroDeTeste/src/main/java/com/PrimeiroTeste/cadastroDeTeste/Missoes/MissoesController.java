package com.PrimeiroTeste.cadastroDeTeste.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

        private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Mandar uma requisiçao para mostrar missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao() {
        return missoesService.listarMissao();
    }

    //POST -- Mandar uma requisiçao para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoesModel){
        return missoesService.criarMissoes(missoesModel);
    }

    //PUT -- Mandar uma requisao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    //DELETE -- Mandar uma requisiçao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorID(@PathVariable Long id){
        missoesService.listarMissaoPorID(id);
        }

    }


