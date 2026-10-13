package lequedevagas.demo.dto.empresa;

import jakarta.validation.constraints.NotBlank;

public record EmpresaRequisicaoDTO(
        @NotBlank(message = "Nome da empresa é obrigatório") String nome,
        @NotBlank(message = "Slug identificador é obrigatório") String slug,
        @NotBlank(message = "Site institucional é obrigatório") String site,
        @NotBlank(message = "Descrição é obrigatória") String descricao
) {}