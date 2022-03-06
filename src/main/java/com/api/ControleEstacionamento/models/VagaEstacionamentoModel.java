package com.api.ControleEstacionamento.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_VAGA_ESTACIONAMENTO")
public class VagaEstacionamentoModel implements Serializable {
    //
    private static final long ID_SERIAL_VERSAO = 1L;

    //Criação dos campo s da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String numeroVaga;
    @Column(nullable = false, unique = true, length = 7)
    private String placaVeiculo;
    @Column(nullable = false, length = 30)
    private String marcaVeiculo;
    @Column(nullable = false, length = 30)
    private String modeloVeiculo;
    @Column(nullable = false, length = 70)
    private String descricaoVeiculo;
    @Column(nullable = false, length = 50)
    private String corVeiculo;
    @Column(nullable = false)
    private LocalDateTime DataRegistro;
    @Column(nullable = false, length = 100)
    private String nomeProprietario;
    @Column(nullable = false, length = 10)
    private int numApartamento;
    @Column(nullable = false, length = 10)
    private String bloco;
    @Column(nullable = false, length = 10)
    private String quadra;
    //final da criação dos campos

}