/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Classificacao;
import br.com.cwi.crescer.moviesign.Servico.ClassificacaoServico;
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
public class ClassificacaoController {

    @Autowired
    private ClassificacaoServico classificacaoServico;

    @RequestMapping(value = "/classificacao", method = GET)
    public Iterable<Classificacao> list() {
        return classificacaoServico.listAll();
    }

    @RequestMapping(value = "/classificacao", method = POST)
    public List<Classificacao> list(@RequestBody Classificacao classificacao) {
        classificacaoServico.adicionar(classificacao);
        return classificacaoServico.listAll();
    }
}
