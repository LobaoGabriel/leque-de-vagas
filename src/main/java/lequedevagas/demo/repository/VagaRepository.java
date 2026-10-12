package lequedevagas.demo.repository;

import lequedevagas.demo.model.Vaga;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository

public class VagaRepository {

    private final Map<Long, Vaga> tabelaVagas = new HashMap<>();

    private final AtomicLong geradorId = new AtomicLong(1);

    public VagaRepository() {

        long id1 = geradorId.getAndIncrement();

        tabelaVagas.put(id1, new Vaga(id1, "Desenvolvedor Backend Júnior", "Vaga para atuar com Java e APIs REST", "Back-end", "Júnior", "Remoto", true, 1L, LocalDate.now()));

        long id2 = geradorId.getAndIncrement();

        tabelaVagas.put(id2, new Vaga(id2, "Estagiário Frontend", "Auxiliar no Next.js do produto principal", "Front-end", "Estágio", "São Paulo, SP", true, 1L, LocalDate.now()));

    }

    public List<Vaga> listarTodas() {

        return new ArrayList<>(tabelaVagas.values());

    }

    public Optional<Vaga> buscarPorId(Long id) {

        return Optional.ofNullable(tabelaVagas.get(id));

    }

    public Vaga salvar(Vaga vaga) {

        if (vaga.getId() == null) {

            vaga.setId(geradorId.getAndIncrement());

            vaga.setPublicadaEm(LocalDate.now());

        }

        tabelaVagas.put(vaga.getId(), vaga);

        return vaga;
    }

    public void deletar(Long id) {
        tabelaVagas.remove(id);
    }
}

