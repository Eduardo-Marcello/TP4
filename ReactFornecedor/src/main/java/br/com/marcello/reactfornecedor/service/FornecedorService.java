package br.com.marcello.reactfornecedor.service;

import br.com.marcello.reactfornecedor.model.Fornecedor;
import br.com.marcello.reactfornecedor.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> getById(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor update(Long id, Fornecedor fornecedor) {
        if (!fornecedorRepository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor com o id " + id + " não existe.");
        }
        fornecedor.setId(id);
        return fornecedorRepository.save(fornecedor);
    }

    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}

