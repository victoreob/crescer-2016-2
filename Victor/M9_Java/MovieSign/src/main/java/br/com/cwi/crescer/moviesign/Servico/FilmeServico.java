/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Servico;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Entity.Filme;
import br.com.cwi.crescer.moviesign.Entity.Genero;
import br.com.cwi.crescer.moviesign.Repositorio.AtorRepositorio;
import br.com.cwi.crescer.moviesign.Repositorio.FilmeRepositorio;
import br.com.cwi.crescer.moviesign.Repositorio.GeneroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Bittencourt
 */
@Service
public class FilmeServico {

    @Autowired
    private FilmeRepositorio filmeRepositorio;

    public List<Filme> listAll() {
        return (List<Filme>) filmeRepositorio.findAll();
    }

    public void adicionar(Filme filme) {
        filmeRepositorio.save(filme);
    }
}
