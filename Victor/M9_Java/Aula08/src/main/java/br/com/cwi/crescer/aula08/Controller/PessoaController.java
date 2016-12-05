/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula08.Controller;

import br.com.cwi.crescer.aula08.Entity.Pessoa;
import br.com.cwi.crescer.aula08.Servico.PessoaServico;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor Eduardo Bittencourt
 */

@RestController
public class PessoaController {

    @Autowired
    PessoaServico pessoaServico;

    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    public List<Pessoa> list() {
        return pessoaServico.listAll();
    }
   
    
    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public List<Pessoa> adicionar(@RequestBody Pessoa p){
        p.setDataNascimento(new Date());
        pessoaServico.add(p);
        return pessoaServico.listAll();
    }
    
}
