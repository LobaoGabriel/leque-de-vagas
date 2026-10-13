package lequedevagas.demo.repository;

import lequedevagas.demo.model.Empresa;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmpresaRepository {
    private final Map<Long, Empresa> tabelaEmpresas = new HashMap<>();
    private final AtomicLong geradorId = new AtomicLong(1);

    public EmpresaRepository() {
        long id1 = geradorId.getAndIncrement();
        tabelaEmpresas.put(id1, new Empresa(id1, "TechInclusiva", "tech-inclusiva", "portal-techinclusiva", "Empresa focada em formação e recrutamento de juniores."));
    }

    public List<Empresa> listarTodas() {
        return new ArrayList<>(tabelaEmpresas.values());
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return Optional.ofNullable(tabelaEmpresas.get(id));
    }

    public Empresa salvar(Empresa empresa) {
        if (empresa.getId() == null) {
            empresa.setId(geradorId.getAndIncrement());
        }
        tabelaEmpresas.put(empresa.getId(), empresa);
        return empresa;
    }
}