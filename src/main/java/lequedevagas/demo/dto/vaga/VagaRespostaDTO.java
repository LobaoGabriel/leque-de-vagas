package lequedevagas.demo.dto.vaga;

import lequedevagas.demo.model.Vaga;

import java.time.LocalDate;

public record VagaRespostaDTO(
        Long id,
        String titulo,
        String descricao,
        String area,
        String senioridade,
        String local,
        Boolean aceitaIniciante,
        Long empresaId,
        LocalDate publicadaEm

) {

    public static VagaRespostaDTO fromModel(Vaga vaga) {

        return new VagaRespostaDTO(
                vaga.getId(),
                vaga.getTitulo(),
                vaga.getDescricao(),
                vaga.getArea(),
                vaga.getSenioridade(),
                vaga.getLocal(),
                vaga.getAceitaIniciante(),
                vaga.getEmpresaId(),
                vaga.getPublicadaEm()
        );
    }
}
