package br.com.cwi.crescer.aula8.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos H. Nonnemacher
 */
@RestController
public class PessoController {

    @Autowired
    private PessoaService service;

    @RequestMapping(value = "/pessoa.json", method = GET)
    public Iterable<Pessoa> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/pessoa.json", method = POST)
    public Iterable<Pessoa> list(@RequestBody Pessoa pessoa) {
        service.add(pessoa);
        return service.listAll();
    }

}
