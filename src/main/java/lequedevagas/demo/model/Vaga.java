package lequedevagas.demo.model;

import java.time.LocalDate;

public class Vaga {
    private Long id;
    private String titulo;
    private String descricao;
    private String area;
    private String senioridade;
    private String local;
    private Boolean aceitaIniciante;
    private Long empresaId;
    private LocalDate publicadaEm;

    public Vaga(String titulo, String descricao, String area, String senioridade, String local, Boolean aceitaIniciante, Long empresaId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.area = area;
        this.senioridade = senioridade;
        this.local = local;
        this.aceitaIniciante = aceitaIniciante;
        this.empresaId = empresaId;
    }

    public Vaga(Long id, String titulo, String descricao, String area, String senioridade, String local, Boolean aceitaIniciante, Long empresaId, LocalDate publicadaEm) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.area = area;
        this.senioridade = senioridade;
        this.local = local;
        this.aceitaIniciante = aceitaIniciante;
        this.empresaId = empresaId;
        this.publicadaEm = publicadaEm;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String getSenioridade() { return senioridade; }
    public void setSenioridade(String senioridade) { this.senioridade = senioridade; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public Boolean getAceitaIniciante() { return aceitaIniciante; }
    public void setAceitaIniciante(Boolean aceitaIniciante) { this.aceitaIniciante = aceitaIniciante; }
    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
    public LocalDate getPublicadaEm() { return publicadaEm; }
    public void setPublicadaEm(LocalDate publicadaEm) { this.publicadaEm = publicadaEm; }
}
