/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula08.Controller;

import br.com.cwi.crescer.aula08.Entity.Pessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Victor Eduardo Bittencourt
 */
@Controller
//@RequestMapping(value = 'UMA_PAGINA_ESPECIFICA')
public class Example {

    private List<Pessoa> pessoas;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String toIndex(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name == null ? "Victor Eduardo Bittencourt" : name);
        return "index";
    }



}
