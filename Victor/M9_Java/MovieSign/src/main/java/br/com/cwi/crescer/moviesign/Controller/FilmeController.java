/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Entity.Filme;
import br.com.cwi.crescer.moviesign.Servico.AtorServico;
import br.com.cwi.crescer.moviesign.Servico.FilmeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor Bittencourt
 */
@RestController
public class FilmeController {

    @Autowired
    private FilmeServico filmeServico;

    @RequestMapping(value = "/filme", method = GET)
    public Iterable<Filme> list() {
        return filmeServico.listAll();
    }

    @RequestMapping(value = "/filme", method = POST)
    public Iterable<Filme> list(@RequestBody Filme filme) {
        filmeServico.adicionar(filme);
        return filmeServico.listAll();
    }
}
