package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criaçao do ninja.")
    } )
        public ResponseEntity <String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)//Mandando pro servidor que esta criado
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    // Mostrar NINJA (READ)
    @GetMapping ("/listar")
    @Operation(summary = "Lista todos os Ninjas", description = "Lista todos os ninjas mostrando todos os atributos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor.")
    } )
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List <NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping ("/listar/{id}")// Summary= RESUMO | Description = Descrição
    @Operation(summary = "Lista um ninja por ID", description = "Essa rota mostra o ninja especificamente por ID")
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
    @Operation(summary = "Altera dados de um Ninja", description = "Altera todos os dados do usuario, para alterações parciais Usar @Patch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja ALTERADO com sucesso(Devolve OK)"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado(ID inexistente"),
            @ApiResponse(responseCode = "500", description = "Erro no Servidor")
    })
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
    @Operation(summary = "Deleta um ninja", description = "Deleta um ninja do banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso(Devolve OK)"),
            @ApiResponse(responseCode = "204", description = "Ninja Foi deletado mas nao tem corpo"),
            @ApiResponse(responseCode = "404", description = "Usou a requisição errada")
    })
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
