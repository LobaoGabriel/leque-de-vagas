package lequedevagas.demo.controller;

import jakarta.validation.Valid;

import lequedevagas.demo.dto.vaga.VagaRequisicaoDTO;
import lequedevagas.demo.dto.vaga.VagaRespostaDTO;
import lequedevagas.demo.service.VagaService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaService vagaService;
    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @GetMapping
    public ResponseEntity<List<VagaRespostaDTO>> listar() {
        return ResponseEntity.ok(vagaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaRespostaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vagaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<VagaRespostaDTO> criar(@RequestBody @Valid VagaRequisicaoDTO dto) {
        VagaRespostaDTO criada = vagaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaRespostaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid VagaRequisicaoDTO dto) {
        return ResponseEntity.ok(vagaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vagaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

