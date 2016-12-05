/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula08.Controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Victor Eduardo Bittencourt
 */
@Controller
public class DataController {

    @ResponseBody
    @RequestMapping(value = "/current_date_time")
    public Date date() {
        return new Date();
    }

}
