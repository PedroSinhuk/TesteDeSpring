package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping ("/boasvindas")
    public String BoasVindas(){
        return "Essa é minha primeira rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
        public ResponseEntity <String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)//Mandando pro servidor que esta criado
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    // Mostrar NINJA (READ)
    @GetMapping ("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List <NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping ("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id){//Usando "?" para ser generic, puxando nome,idade...
        NinjaDTO ninjasPorID = ninjaService.listarNinjaPorID(id);
        if(ninjasPorID != null){//Fazendo Validação para confirmar que existe o ninja
            return ResponseEntity.ok("Ninja encontrado: " + ninjasPorID.getNome());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)//Caso o usuario digite um id que não existe
                    .body("Ninja com id: " + " nao existe nos nossos resgistros");
        }
    }
    //Validações sao necessarias em que todas as vezes o usuario possa passar algo que nao existe
    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinjaPorID(id, ninjaAtualizado);
            if (ninja != null){
                return ResponseEntity.ok(ninja);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ninja com esse ID não encontrado");
            }

        }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        if (ninjaService.listarNinjaPorID(id) != null) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja deletado com ID " + id + "deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id " + id + " não encontrado");
        }
    }

}
