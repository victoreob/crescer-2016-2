/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Entity.Elenco;
import br.com.cwi.crescer.moviesign.Servico.AtorServico;
import br.com.cwi.crescer.moviesign.Servico.ElencoServico;
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
public class ElencoController {

    @Autowired
    private ElencoServico elencoServico;

    @RequestMapping(value = "/elenco", method = GET)
    public List<Elenco> list() {
        return elencoServico.listAll();
    }

    @RequestMapping(value = "/elenco", method = POST)
    public Iterable<Elenco> list(@RequestBody Elenco elenco) {
        elencoServico.adicionar(elenco);
        return elencoServico.listAll();
    }
}
