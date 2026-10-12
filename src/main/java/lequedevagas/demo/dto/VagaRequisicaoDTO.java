package lequedevagas.demo.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;

public record VagaRequisicaoDTO(
        @NotBlank(message = "Título é obrigatório") String titulo,
        @NotBlank(message = "Descrição é obrigatória") String descricao,
        @NotBlank(message = "Área é obrigatória") String area,
        @NotBlank(message = "Senioridade é obrigatória") String senioridade,
        @NotBlank(message = "Local é obrigatório") String local,
        @NotNull(message = "Informe se aceita iniciante") Boolean aceitaIniciante,
        @NotNull(message = "Empresa ID é obrigatório") Long empresaId

) {}






