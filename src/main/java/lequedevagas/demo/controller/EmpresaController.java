package lequedevagas.demo.controller;

import lequedevagas.demo.dto.empresa.EmpresaRequisicaoDTO;
import lequedevagas.demo.dto.empresa.EmpresaRespostaDTO;
import lequedevagas.demo.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<EmpresaRespostaDTO>> listar() {
        return ResponseEntity.ok(empresaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaRespostaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EmpresaRespostaDTO> criar(@RequestBody @Valid EmpresaRequisicaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.criar(dto));
    }
}