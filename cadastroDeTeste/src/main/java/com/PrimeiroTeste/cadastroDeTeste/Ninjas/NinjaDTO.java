package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import com.PrimeiroTeste.cadastroDeTeste.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {


    private Long id;


    private String nome;


    private String email;


    private String imgUrl;


    private int idade;


    private MissoesModel missoes;

    private String rank;

}
