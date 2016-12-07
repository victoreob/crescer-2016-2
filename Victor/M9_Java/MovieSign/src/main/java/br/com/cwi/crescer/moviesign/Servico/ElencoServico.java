/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Servico;

import br.com.cwi.crescer.moviesign.Entity.Elenco;
import br.com.cwi.crescer.moviesign.Repositorio.ElencoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Bittencourt
 */
@Service
public class ElencoServico {

    @Autowired
    private ElencoRepositorio elencoRepositorio;

    public List<Elenco> listAll() {
        return (List<Elenco>) elencoRepositorio.findAll();
    }

    public void adicionar(Elenco elenco) {
        elencoRepositorio.save(elenco);
    }
}
