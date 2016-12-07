/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Servico;

import br.com.cwi.crescer.moviesign.Entity.Idioma;
import br.com.cwi.crescer.moviesign.Repositorio.IdiomaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Bittencourt
 */
@Service
public class IdiomaServico {

    @Autowired
    private IdiomaRepositorio idiomaRepositorio;

    public List<Idioma> listAll() {
        return (List<Idioma>) idiomaRepositorio.findAll();
    }

    public void adicionar(Idioma idioma) {
        idiomaRepositorio.save(idioma);
    }
}
