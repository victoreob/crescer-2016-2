/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Servico;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Entity.Genero;
import br.com.cwi.crescer.moviesign.Repositorio.GeneroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Bittencourt
 */
@Service
public class GeneroServico {

    @Autowired
    private GeneroRepositorio generoRepositorio;

    public List<Genero> listAll() {
        return (List<Genero>) generoRepositorio.findAll();
    }

    public void adicionar(Genero genero) {
        generoRepositorio.save(genero);
    }
    
    public Page<Genero> findAll(Pageable pgbl) {
        return generoRepositorio.findAll(pgbl);
    }

    public Iterable<Genero> findAll() {
        return generoRepositorio.findAll();
    }
    
    public Genero findOne(Long id) {
        return generoRepositorio.findOne(id);
    }
}
