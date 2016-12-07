/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Servico;

import br.com.cwi.crescer.moviesign.Entity.Classificacao;
import br.com.cwi.crescer.moviesign.Repositorio.ClassificacaoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Bittencourt
 */
@Service
public class ClassificacaoServico {

    @Autowired
    private ClassificacaoRepositorio classificacaoRepositorio;

    public List<Classificacao> listAll() {
        return (List<Classificacao>) classificacaoRepositorio.findAll();
    }

    public void adicionar(Classificacao classificacao) {
        classificacaoRepositorio.save(classificacao);
    }
}
