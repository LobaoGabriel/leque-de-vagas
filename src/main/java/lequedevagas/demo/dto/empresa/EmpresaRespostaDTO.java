package lequedevagas.demo.dto.empresa;

import lequedevagas.demo.model.Empresa;

public record EmpresaRespostaDTO(
        Long id,
        String nome,
        String slug,
        String site,
        String descricao
) {
    public static EmpresaRespostaDTO fromModel(Empresa e) {
        return new EmpresaRespostaDTO(e.getId(), e.getNome(), e.getSlug(), e.getSite(), e.getDescricao());
    }
}