package com.api.ControleEstacionamento.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class VagaEstacionamentoDto {
    //
    @NotBlank
    @Size(max = 7)
    private String numeroVaga;
    @NotBlank
    @Size(max = 7)
    private String placaVeiculo;
    @NotBlank
    @Size(max = 30)
    private String marcaVeiculo;
    @NotBlank
    @Size(max = 30)
    private String modeloVeiculo;
    @NotBlank
    @Size(max = 70)
    private String descricaoVeiculo;
    @NotBlank
    @Size(max = 50)
    private String corVeiculo;
    @NotBlank
    @Size(max = 100)
    private String nomeProprietario;
    @NotBlank
    @Size(max = 10)
    private String numApartamento;
    @NotBlank
    @Size(max = 10)
    private String bloco;
    @NotBlank
    @Size(max = 10)
    private String quadra;

}
