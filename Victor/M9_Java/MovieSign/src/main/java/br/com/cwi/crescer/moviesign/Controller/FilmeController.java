/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Filme;
import br.com.cwi.crescer.moviesign.Servico.ClassificacaoServico;
import br.com.cwi.crescer.moviesign.Servico.ElencoServico;
import br.com.cwi.crescer.moviesign.Servico.FilmeServico;
import br.com.cwi.crescer.moviesign.Servico.GeneroServico;
import br.com.cwi.crescer.moviesign.Servico.IdiomaServico;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeServico filmeServico;
    
    @Autowired
    private GeneroServico generoServico;
    
    @Autowired
    private IdiomaServico idiomaServico;
    
    @Autowired
    private ClassificacaoServico classificacaoServico;
    
    @Autowired
    private ElencoServico elencoServico;

@RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Filme filme = new Filme();
        if (id != null) {
            filme = filmeServico.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("filme", filme);
        model.addAttribute("filmes", filmeServico.findAll(pageable));
        model.addAttribute("elencos", elencoServico.findAll());
        model.addAttribute("classificacoes", classificacaoServico.findAll());
        model.addAttribute("idiomas", idiomaServico.findAll());
        model.addAttribute("generos", generoServico.findAll());
        return "filme";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Filme filme, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            filmeServico.adicionar(filme);
            return "redirect:filme";
        }
        return "filme";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Filme> filmes = filmeServico.findAll(pageable);
        model.addAttribute("filmes", filmes);
        return "filme";
    }

    public Iterable<Filme> list() {
        return filmeServico.listAll();
    }

    @RequestMapping(value = "/filme", method = POST)
    public Iterable<Filme> list(@RequestBody Filme filme) {
        filmeServico.adicionar(filme);
        return filmeServico.listAll();
    }
}
