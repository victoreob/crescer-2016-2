/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Servico;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Repositorio.AtorRepositorio;
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
public class AtorServico {

    @Autowired
    private AtorRepositorio atorRepositorio;

    public List<Ator> listAll() {
        return (List<Ator>) atorRepositorio.findAll();
    }

    public Page<Ator> findAll(Pageable pgbl) {
        return atorRepositorio.findAll(pgbl);
    }

    public Iterable<Ator> findAll() {
        return atorRepositorio.findAll();
    }

    public void adicionar(Ator ator) {
        atorRepositorio.save(ator);
    }

    public Ator findOne(Long id) {
        return atorRepositorio.findOne(id);
    }

}
