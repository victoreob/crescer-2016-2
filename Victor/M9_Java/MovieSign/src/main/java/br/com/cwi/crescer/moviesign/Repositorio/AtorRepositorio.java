/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Repositorio;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Victor Bittencourt
 */
public interface AtorRepositorio extends CrudRepository<Ator, Long>, PagingAndSortingRepository<Ator, Long>{
    
}
