/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula08.Repositório;

import br.com.cwi.crescer.aula08.Entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Victor Eduardo Bittencourt
 */
public interface PessoaRepositorio extends CrudRepository<Pessoa, Long> {
    
}
