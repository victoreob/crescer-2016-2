/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Genero;
import br.com.cwi.crescer.moviesign.Servico.GeneroServico;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victor Bittencourt
 */
@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroServico generoServico;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Genero genero = new Genero();
        if (id != null) {
            genero = generoServico.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("genero", genero);
        model.addAttribute("generos", generoServico.findAll(pageable));
        return "genero";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Genero genero, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            generoServico.adicionar(genero);
            return "redirect:genero";
        }
        return "genero";
    }

    public Iterable<Genero> list() {
        return generoServico.listAll();
    }

    @RequestMapping(value = "/ator", method = POST)
    public Iterable<Genero> list(@RequestBody Genero genero) {
        generoServico.adicionar(genero);
        return generoServico.listAll();
    }
}
