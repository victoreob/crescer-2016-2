/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Servico.AtorServico;
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
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorServico atorServico;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Ator ator = new Ator();
        if (id != null) {
            ator = atorServico.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("ator", ator);
        model.addAttribute("atores", atorServico.findAll(pageable));
        return "ator";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Ator ator, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            atorServico.adicionar(ator);
            return "redirect:ator";
        }
        return "ator";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Ator> atores = atorServico.findAll(pageable);
        model.addAttribute("atores", atores);
        return "ator";
    }

    public Iterable<Ator> list() {
        return atorServico.listAll();
    }

    @RequestMapping(value = "/ator", method = POST)
    public Iterable<Ator> list(@RequestBody Ator ator) {
        atorServico.adicionar(ator);
        return atorServico.listAll();
    }
}
