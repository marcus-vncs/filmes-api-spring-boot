package tech.ada.filmes_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.filmes_api.model.Filme;
import tech.ada.filmes_api.service.FilmeService;

import java.util.Map;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    @Autowired
    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {
        return filmeService.buscarPorId(id)
                .map(filme -> ResponseEntity.ok(filme))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Filme> criar(@RequestBody Filme filme) {
        try {
            Filme novoFilme = filmeService.salvar(filme);
            return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarCompleto(@PathVariable Long id, @RequestBody Filme filmeDetalhes) {
        try {
            Filme filmeAtualizado = filmeService.atualizarCompleto(id, filmeDetalhes);
            return ResponseEntity.ok(filmeAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            filmeService.deletarPorId(id);
            // Retorna HTTP 204 No Content (Sucesso sem corpo de resposta)
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Tratamento simples se houver falha na exclusão (ex: ID não existe)
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Filme> atualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        // Por enquanto, retornamos o status de "Não Implementado" (501)
        // apenas para garantir que o endpoint esteja mapeado.

        // Retornaremos o status 501 (Not Implemented) temporariamente.
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .build();
    }
}