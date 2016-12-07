/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Genero;
import br.com.cwi.crescer.moviesign.Servico.GeneroServico;
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
public class GeneroController {

    @Autowired
    private GeneroServico generoServico;

    @RequestMapping(value = "/genero", method = GET)
    public Iterable<Genero> list() {
        return generoServico.listAll();
    }

    @RequestMapping(value = "/genero", method = POST)
    public Iterable<Genero> list(@RequestBody Genero genero) {
        generoServico.adicionar(genero);
        return generoServico.listAll();
    }
}
