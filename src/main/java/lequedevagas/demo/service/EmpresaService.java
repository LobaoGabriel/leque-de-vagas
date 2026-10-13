package lequedevagas.demo.service;

import lequedevagas.demo.dto.empresa.EmpresaRequisicaoDTO;
import lequedevagas.demo.dto.empresa.EmpresaRespostaDTO;
import lequedevagas.demo.exception.RecursoNaoEncontradoException;
import lequedevagas.demo.model.Empresa;
import lequedevagas.demo.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaRespostaDTO> listarTodas() {
        return empresaRepository.listarTodas().stream()
                .map(EmpresaRespostaDTO::fromModel)
                .toList();
    }

    public EmpresaRespostaDTO buscarPorId(Long id) {
        Empresa empresa = empresaRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa com ID " + id + " não encontrada"));
        return EmpresaRespostaDTO.fromModel(empresa);
    }

    public EmpresaRespostaDTO criar(EmpresaRequisicaoDTO dto) {
        Empresa empresa = new Empresa(dto.nome(), dto.slug(), dto.site(), dto.descricao());
        return EmpresaRespostaDTO.fromModel(empresaRepository.salvar(empresa));
    }
}