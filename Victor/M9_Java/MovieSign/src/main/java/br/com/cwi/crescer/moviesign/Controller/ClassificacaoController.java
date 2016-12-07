/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.moviesign.Controller;

import br.com.cwi.crescer.moviesign.Entity.Classificacao;
import br.com.cwi.crescer.moviesign.Servico.ClassificacaoServico;
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
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victor Bittencourt
 */
@Controller
@RequestMapping("/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoServico classificacaoServico;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Classificacao classificacao = new Classificacao();
        if (id != null) {
            classificacao = classificacaoServico.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("classificacao", classificacao);
        model.addAttribute("classificacoes", classificacaoServico.findAll(pageable));
        return "classificacao";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Classificacao classificacao, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            classificacaoServico.adicionar(classificacao);
            return "redirect:classificacao";
        }
        return "classificacao";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Classificacao> classificacoes = classificacaoServico.findAll(pageable);
        model.addAttribute("classifificacoes", classificacoes);
        return "classificacao";
    }

    public List<Classificacao> list() {
        return classificacaoServico.listAll();
    }

    @RequestMapping(value = "/classificacao", method = POST)
    public List<Classificacao> list(@RequestBody Classificacao classificacao) {
        classificacaoServico.adicionar(classificacao);
        return classificacaoServico.listAll();
    }
}
