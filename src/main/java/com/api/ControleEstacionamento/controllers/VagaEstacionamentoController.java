package com.api.ControleEstacionamento.controllers;

import com.api.ControleEstacionamento.dtos.VagaEstacionamentoDto;
import com.api.ControleEstacionamento.models.VagaEstacionamentoModel;
import com.api.ControleEstacionamento.services.VagaEstacionamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/vaga_estacionamento/vagas")

public class VagaEstacionamentoController {
    //
    final VagaEstacionamentoService vagaEstacionamentoService;

    public VagaEstacionamentoController(VagaEstacionamentoService vagaEstacionamentoService) {
        this.vagaEstacionamentoService = vagaEstacionamentoService;
    }
    /*
    Método de requisição para gravação de um novo registro na base de dados
     */
    @PostMapping
    public ResponseEntity<Object> salvarVagaEstacionamento(@RequestBody @Valid VagaEstacionamentoDto vagaEstacionamentoDto){
        //se a placa ja estiver registrada
        if (vagaEstacionamentoService.existsByPlacaveiculo(vagaEstacionamentoDto.getPlacaVeiculo())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Atenção: Placa de veículo já registrada");
        }
        // Se a vaga já estver ocupada
        if (vagaEstacionamentoService.existsByNumeroVaga(vagaEstacionamentoDto.getNumeroVaga())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Atenção: Vaga ja está em uso");
        }

        var vagaEstacionamentoModel = new VagaEstacionamentoModel();
        BeanUtils.copyProperties(vagaEstacionamentoDto, vagaEstacionamentoModel);
        vagaEstacionamentoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaEstacionamentoService.save(vagaEstacionamentoModel));
    }

    //Retonar todos os registros
    @GetMapping
    public ResponseEntity<Page<VagaEstacionamentoModel>> getAllVagaEstacionamento(@PageableDefault(page = 0,
                                                                                                   size = 10,
                                                                                                   sort = "id",
                                                                                                   direction = Sort.Direction.ASC)
                                                                                  Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaEstacionamentoService.findAll(pageable));
    }

    //Retornar por registro
    @GetMapping("/{id}")
    public ResponseEntity<VagaEstacionamentoModel> getIdVagaEstacionamento(@PathVariable(value = "id") UUID id) {
        Optional<VagaEstacionamentoModel> vagaEstacionamentoModelOptional = vagaEstacionamentoService.findById(id);
        if (vagaEstacionamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoModelOptional.get());
        }
        return null;
    }

    //Deletar um registro
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIdVagaEstacionamento(@PathVariable(value = "id") UUID id) {
        Optional<VagaEstacionamentoModel> vagaEstacionamentoModelOptional = vagaEstacionamentoService.findById(id);
        if (vagaEstacionamentoModelOptional.isPresent()) {
            vagaEstacionamentoService.delete(vagaEstacionamentoModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
    }

    //Atualizar informações
    @PutMapping("/{id}")
    public ResponseEntity<VagaEstacionamentoModel> deleteIdVagaEstacionamento(@PathVariable(value = "id") UUID id,
                                                                              @RequestBody
                                                                              @Valid VagaEstacionamentoDto vagaEstacionamentoDto) {
        Optional<VagaEstacionamentoModel> vagaEstacionamentoModelOptional = vagaEstacionamentoService.findById(id);
        if (vagaEstacionamentoModelOptional.isPresent()) {
            var vagaEstacionamentoModel = new VagaEstacionamentoModel();
            // Set dos novos valores para atualização do registro
            BeanUtils.copyProperties(vagaEstacionamentoDto, vagaEstacionamentoModel);
            vagaEstacionamentoModel.setId(vagaEstacionamentoModelOptional.get().getId());
            vagaEstacionamentoModel.setDataRegistro(vagaEstacionamentoModelOptional.get().getDataRegistro());
            return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoService.save(vagaEstacionamentoModel));
        }
        return null;
    }
}
