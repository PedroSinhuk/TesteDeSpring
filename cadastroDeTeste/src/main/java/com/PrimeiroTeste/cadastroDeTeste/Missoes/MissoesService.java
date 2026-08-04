package com.PrimeiroTeste.cadastroDeTeste.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

   private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar Missoes
    public List<MissoesModel> listarMissao (){
        return missoesRepository.findAll();
    }

    //Optional
    public MissoesModel listarMissaoPorID(Long id){
        Optional<MissoesModel> missoesPorID = missoesRepository.findById(id);
        return missoesPorID.orElse(null);
    }

    //Criar missoes
    public MissoesModel criarMissoes(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    //Deletar missoes
    public void deletarMissaoPorID(Long id){
        missoesRepository.deleteById(id);
    }





}
