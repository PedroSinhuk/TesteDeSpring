package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }


    //Optional: caso nao tenha o id procurado pelo usuario, assim se usa tambem o orElse para mostrar o resultado null.
    public NinjaModel listarNinjaPorID(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar Ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar Ninja - Tem que ser metodo Void
    public void deletarNinjaPorID (Long id){
         ninjaRepository.deleteById(id);
    }

    //Atualizar ninja

    public NinjaModel atualizarNinjaPorID(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }


}
