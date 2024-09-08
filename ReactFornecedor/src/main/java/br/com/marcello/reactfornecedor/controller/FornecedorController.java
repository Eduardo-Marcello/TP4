package br.com.marcello.reactfornecedor.controller;
import br.com.marcello.reactfornecedor.model.Fornecedor;
import br.com.marcello.reactfornecedor.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class FornecedorController {
    private final FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Fornecedor> getFornecedorById(@PathVariable Long id) {
        return fornecedorService.getById(id);
    }

    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @PutMapping("/{id}")
    public Fornecedor updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.update(id, fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        fornecedorService.delete(id);
    }
}

