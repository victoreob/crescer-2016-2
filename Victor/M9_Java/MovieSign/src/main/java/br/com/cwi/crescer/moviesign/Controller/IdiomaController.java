/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Ator;
import br.com.cwi.crescer.moviesign.Entity.Idioma;
import br.com.cwi.crescer.moviesign.Servico.AtorServico;
import br.com.cwi.crescer.moviesign.Servico.IdiomaServico;
import java.util.List;
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
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victor Bittencourt
 */
@Controller
@RequestMapping("/idioma")
public class IdiomaController {

    @Autowired
    private IdiomaServico idiomaServico;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Idioma idioma = new Idioma();
        if (id != null) {
            idioma = idiomaServico.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("idioma", idioma);
        model.addAttribute("idiomas", idiomaServico.findAll(pageable));
        return "idioma";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Idioma idioma, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            idiomaServico.adicionar(idioma);
            return "redirect:idioma";
        }
        return "idioma";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Idioma> idiomas = idiomaServico.findAll(pageable);
        model.addAttribute("idiomas", idiomas);
        return "idioma";
    }

    public Iterable<Idioma> list() {
        return idiomaServico.listAll();
    }

    @RequestMapping(value = "/ator", method = POST)
    public Iterable<Idioma> list(@RequestBody Idioma idioma) {
        idiomaServico.adicionar(idioma);
        return idiomaServico.listAll();
    }
}
