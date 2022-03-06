package com.api.ControleEstacionamento.repositories;

import com.api.ControleEstacionamento.models.VagaEstacionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VagaEstacionamentoRepository extends JpaRepository<VagaEstacionamentoModel, UUID> {

    //Métodos para validar a existencia dos valores na base de dados

    boolean existsByPlacaVeiculo(String placaVeiculo);
    boolean existsByNumeroVaga(String numeroVaga);


    Optional<VagaEstacionamentoModel> findAllById(UUID id);


}
