package br.com.ifpe.oxefood.modelo.categoriaproduto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        categoriaProduto.setHabilitado(Boolean.TRUE);
        categoriaProduto.setVersao(1L);
        categoriaProduto.setDataCriacao(LocalDate.now());
        return repository.save(categoriaProduto);
    }

    public List<CategoriaProduto> listarTodos() {
        return repository.findAll();
    }

    public CategoriaProduto obterPorID(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaAlterada) {
        CategoriaProduto categoria = obterPorID(id);
        categoria.setDescricao(categoriaAlterada.getDescricao());
        categoria.setVersao(categoria.getVersao() + 1);
        repository.save(categoria);
    }

    @Transactional
    public void delete(Long id) {
        CategoriaProduto categoria = obterPorID(id);
        categoria.setHabilitado(Boolean.FALSE);
        categoria.setVersao(categoria.getVersao() + 1);
        repository.save(categoria);
    }
}