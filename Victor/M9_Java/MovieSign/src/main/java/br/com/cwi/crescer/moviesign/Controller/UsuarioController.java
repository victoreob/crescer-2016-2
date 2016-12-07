/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Usuario;
import br.com.cwi.crescer.moviesign.Servico.UsuarioServico;
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
public class UsuarioController {

    @Autowired
    private UsuarioServico usuarioServico;

    @RequestMapping(value = "/cadastrar", method = GET)
    public Iterable<Usuario> list() {
        return usuarioServico.listAll();
    }

    @RequestMapping(value = "/cadastrar", method = POST)
    public List<Usuario> list(@RequestBody Usuario usuario) {
        usuarioServico.adicionar(usuario);
        return usuarioServico.listAll();
    }
}
