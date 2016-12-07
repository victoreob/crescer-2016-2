/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Servico;

import br.com.cwi.crescer.moviesign.Entity.Idioma;
import br.com.cwi.crescer.moviesign.Entity.Usuario;
import br.com.cwi.crescer.moviesign.Repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Bittencourt
 */
@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    
     public List<Usuario> listAll() {
        return (List<Usuario>) usuarioRepositorio.findAll();
    }

    public void adicionar(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }
}
