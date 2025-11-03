package tech.ada.filmes_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.ada.filmes_api.model.Filme;
import tech.ada.filmes_api.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme salvar(Filme filme) {
        if (filme.getTitulo() == null || filme.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("O título d filme é obrigatório.");
        }
        return filmeRepository.save(filme);
    }

    public List<Filme> buscarTodos() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return filmeRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        filmeRepository.deleteById(id);
    }

    public Filme atualizarCompleto(Long id, Filme filmeDetalhes) {
        return buscarPorId(id).map(filmeExistente -> {
            filmeExistente.setTitulo(filmeDetalhes.getTitulo());
            filmeExistente.setAnoLancamento(filmeDetalhes.getAnoLancamento());
            filmeExistente.setDiretor(filmeDetalhes.getDiretor());
            filmeExistente.setGenero(filmeDetalhes.getGenero());
            filmeExistente.setSinopse(filmeDetalhes.getSinopse());
            return filmeRepository.save(filmeExistente);
        }) .orElseThrow(() ->
                new IllegalArgumentException("Filme não encontrado para o ID: " + id));
    }

    public Filme atualizarParcial(Long id, Filme filmeDetalhes) {

        return filmeRepository.findById(id)
                .map(filmeExistente -> {
                    if (StringUtils.hasText(filmeDetalhes.getTitulo())) {
                        filmeExistente.setTitulo(filmeDetalhes.getTitulo());
                    }
                    if (filmeDetalhes.getAnoLancamento() != null) {
                        filmeExistente.setAnoLancamento(filmeDetalhes.getAnoLancamento());
                    }
                    if (StringUtils.hasText(filmeDetalhes.getDiretor())) {
                        filmeExistente.setDiretor(filmeDetalhes.getDiretor());
                    }
                    if (StringUtils.hasText(filmeDetalhes.getGenero())) {
                        filmeExistente.setGenero(filmeDetalhes.getGenero());
                    }
                    if (StringUtils.hasText(filmeDetalhes.getSinopse())) {
                        filmeExistente.setSinopse(filmeDetalhes.getSinopse());
                    }

                    return filmeRepository.save(filmeExistente);
                })
                .orElseThrow(() -> new IllegalArgumentException("Filme não encontrado para o ID: " + id));
    }
}
