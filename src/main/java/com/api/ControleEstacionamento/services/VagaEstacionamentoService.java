package com.api.ControleEstacionamento.services;

import com.api.ControleEstacionamento.models.VagaEstacionamentoModel;
import com.api.ControleEstacionamento.repositories.VagaEstacionamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class VagaEstacionamentoService {
    //
    final VagaEstacionamentoRepository vagaEstacionamentoRepository;

    public VagaEstacionamentoService(VagaEstacionamentoRepository vagaEstacionamentoRepository) {
        this.vagaEstacionamentoRepository = vagaEstacionamentoRepository;
    }

    @Transactional
    public VagaEstacionamentoModel save(VagaEstacionamentoModel vagaEstacionamentoModel) {
        return vagaEstacionamentoRepository.save(vagaEstacionamentoModel);
    }

    public boolean existsByPlacaveiculo(String placaVeiculo) {
        return vagaEstacionamentoRepository.existsByPlacaVeiculo(placaVeiculo);
    }
    public boolean existsByNumeroVaga(String numeroVaga) {
        return vagaEstacionamentoRepository.existsByNumeroVaga(numeroVaga);
    }

    //Retorna todos os registros das vagas
    public Page<VagaEstacionamentoModel> findAll(Pageable pageable) {
        return vagaEstacionamentoRepository.findAll(pageable);
    }

    public Optional <VagaEstacionamentoModel> findById(UUID id) {
        return vagaEstacionamentoRepository.findAllById(id);
    }
    @Transactional
    public void delete(VagaEstacionamentoModel vagaEstacionamentoModel) {
        vagaEstacionamentoRepository.delete(vagaEstacionamentoModel);
    }

}
