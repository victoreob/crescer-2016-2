/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Elenco;
import br.com.cwi.crescer.moviesign.Servico.AtorServico;
import br.com.cwi.crescer.moviesign.Servico.ElencoServico;
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
@RequestMapping("/elenco")
public class ElencoController {

    @Autowired
    private ElencoServico elencoServico;
    
    @Autowired
    private AtorServico atorServico;

@RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Elenco elenco = new Elenco();
        if (id != null) {
            elenco = elencoServico.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("elenco", elenco);
        model.addAttribute("elencos", elencoServico.findAll(pageable));
        model.addAttribute("atores", atorServico.findAll());
        return "elenco";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Elenco elenco, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            elencoServico.adicionar(elenco);
            return "redirect:elenco";
        }
        return "elenco";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Elenco> elencos = elencoServico.findAll(pageable);
        model.addAttribute("elencos", elencos);
        return "elenco";
    }

    public Iterable<Elenco> list() {
        return elencoServico.listAll();
    }

    @RequestMapping(value = "/elenco", method = POST)
    public Iterable<Elenco> list(@RequestBody Elenco elenco) {
        elencoServico.adicionar(elenco);
        return elencoServico.listAll();
    }
}
