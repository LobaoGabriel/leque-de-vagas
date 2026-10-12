package lequedevagas.demo.model;

public class Empresa {
    private Long id;
    private String nome;
    private String slug;
    private String site;
    private String descricao;

    public Empresa(String nome, String slug, String site, String descricao) {
        this.nome = nome;
        this.slug = slug;
        this.site = site;
        this.descricao = descricao;
    }

    public Empresa(Long id, String nome, String slug, String site, String descricao) {
        this.id = id;
        this.nome = nome;
        this.slug = slug;
        this.site = site;
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}