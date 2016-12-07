/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Entity.Idioma;
import br.com.cwi.crescer.moviesign.Servico.AtorServico;
import br.com.cwi.crescer.moviesign.Servico.IdiomaServico;
import java.util.List;
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
public class IdiomaController {

    @Autowired
    private IdiomaServico idiomaServico;

    @RequestMapping(value = "/idioma", method = GET)
    public Iterable<Idioma> list() {
        return idiomaServico.listAll();
    }

    @RequestMapping(value = "/idioma", method = POST)
    public List<Idioma> list(@RequestBody Idioma idioma) {
        idiomaServico.adicionar(idioma);
        return idiomaServico.listAll();
    }
}
