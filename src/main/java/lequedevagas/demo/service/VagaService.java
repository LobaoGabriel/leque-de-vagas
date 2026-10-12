package lequedevagas.demo.service;

import lequedevagas.demo.dto.VagaRequisicaoDTO;
import lequedevagas.demo.dto.VagaRespostaDTO;
import lequedevagas.demo.exception.RecursoNaoEncontradoException;
import lequedevagas.demo.model.Vaga;
import lequedevagas.demo.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public List<VagaRespostaDTO> listarTodas() {
        return vagaRepository.listarTodas().stream()
                .map(VagaRespostaDTO::fromModel)
                .toList();
    }

    public VagaRespostaDTO buscarPorId(Long id) {

        Vaga vaga = vagaRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Vaga com ID " + id + " não encontrada"));
        return VagaRespostaDTO.fromModel(vaga);

    }

    public VagaRespostaDTO criar(VagaRequisicaoDTO dto) {
        Vaga vaga = new Vaga(
                dto.titulo(),
                dto.descricao(),
                dto.area(),
                dto.senioridade(),
                dto.local(),
                dto.aceitaIniciante(),
                dto.empresaId()
        );

        return VagaRespostaDTO.fromModel(vagaRepository.salvar(vaga));
    }

    public VagaRespostaDTO atualizar(Long id, VagaRequisicaoDTO dto) {
        Vaga existente = vagaRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Vaga com ID " + id + " não encontrada"));

        existente.setTitulo(dto.titulo());
        existente.setDescricao(dto.descricao());
        existente.setArea(dto.area());
        existente.setSenioridade(dto.senioridade());
        existente.setLocal(dto.local());
        existente.setAceitaIniciante(dto.aceitaIniciante());
        existente.setEmpresaId(dto.empresaId());

        return VagaRespostaDTO.fromModel(vagaRepository.salvar(existente));
    }

    public void deletar(Long id) {

        vagaRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Vaga com ID " + id + " não encontrada"));
        vagaRepository.deletar(id);
    }
}

