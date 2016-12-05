/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula08.Servico;

import br.com.cwi.crescer.aula08.Entity.Pessoa;
import br.com.cwi.crescer.aula08.Repositório.PessoaRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Eduardo Bittencourt
 */
@Service
public class PessoaServico {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    public List<Pessoa> listAll() {
        return (List<Pessoa>) pessoaRepositorio.findAll();
    }

    public void add(Pessoa p) {
        p.setDataNascimento(new Date());
        pessoaRepositorio.save(p);
    }
}
