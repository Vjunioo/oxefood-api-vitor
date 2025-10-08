package br.com.ifpe.oxefood.modelo.estado;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    @Transactional
    public Estado save(Estado estado) {
        estado.setHabilitado(Boolean.TRUE);
        estado.setVersao(1L);
        estado.setDataCriacao(LocalDate.now());
        return repository.save(estado);
    }

    public List<Estado> listarTodos() {
        return repository.findAll();
    }

    public Estado obterPorID(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado."));
    }

    @Transactional
    public void update(Long id, Estado estadoAlterado) {
        Estado estado = obterPorID(id);
        estado.setNome(estadoAlterado.getNome());
        estado.setSigla(estadoAlterado.getSigla());
        estado.setVersao(estado.getVersao() + 1);
        repository.save(estado);
    }

    @Transactional
    public void delete(Long id) {
        Estado estado = obterPorID(id);
        estado.setHabilitado(Boolean.FALSE);
        estado.setVersao(estado.getVersao() + 1);
        repository.save(estado);
    }
}