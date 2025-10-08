package br.com.ifpe.oxefood.modelo.cidade;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Transactional
    public Cidade save(Cidade cidade) {
        cidade.setHabilitado(Boolean.TRUE);
        cidade.setVersao(1L);
        cidade.setDataCriacao(LocalDate.now());
        return repository.save(cidade);
    }

    public List<Cidade> listarTodos() {
        return repository.findAll();
    }

    public Cidade obterPorID(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cidade não encontrada."));
    }

    @Transactional
    public void update(Long id, Cidade cidadeAlterada) {
        Cidade cidade = obterPorID(id);
        cidade.setNome(cidadeAlterada.getNome());
        cidade.setEstado(cidadeAlterada.getEstado());
        cidade.setQtdPopulacao(cidadeAlterada.getQtdPopulacao());
        cidade.setEhCapital(cidadeAlterada.getEhCapital());
        cidade.setDataFundacao(cidadeAlterada.getDataFundacao());
        
        cidade.setVersao(cidade.getVersao() + 1);
        repository.save(cidade);
    }

    @Transactional
    public void delete(Long id) {
        Cidade cidade = obterPorID(id);
        cidade.setHabilitado(Boolean.FALSE);
        cidade.setVersao(cidade.getVersao() + 1);
        repository.save(cidade);
    }
}