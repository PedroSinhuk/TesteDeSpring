package com.PrimeiroTeste.cadastroDeTeste.Ninjas;

import com.PrimeiroTeste.cadastroDeTeste.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity transforma uma classe em uma entidade do banco de dados!
@Entity
@Table (name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_Url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    //@ManyToOne - um ninja uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")//Foreing Key ou chave estrangeira
    private MissoesModel missoes;


}
