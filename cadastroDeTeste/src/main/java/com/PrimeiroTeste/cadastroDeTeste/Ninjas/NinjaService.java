package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaMapper ninjaMapper;
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas= ninjaRepository.findAll();
    return ninjas.stream()
            .map(ninjaMapper::map)
            .collect(Collectors.toList());
    }
    //Optional: caso nao tenha o id procurado pelo usuario, assim se usa tambem o orElse para mostrar o resultado null.
    public NinjaDTO listarNinjaPorID(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Criar Ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar Ninja - Tem que ser metodo Void
    public void deletarNinjaPorID (Long id){
         ninjaRepository.deleteById(id);
    }

    //Atualizar ninja

    public NinjaDTO atualizarNinjaPorID(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }


}
