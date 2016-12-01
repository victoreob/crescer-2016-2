package br.com.cwi.crescer.aula05;

import Entity.Idioma;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author Victor
 */
@ManagedBean
@ViewScoped
public class CadastroIdioma {

    @EJB
    private IdiomaBean idiomaBean;
    
    private Idioma idioma;
    private List<Idioma> idiomas;

    @PostConstruct
    public void init() {
        this.idioma = new Idioma();
        this.idiomas = idiomaBean.findAll();
        //this.classificacao.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public void adicionar() {
        idiomaBean.insert(idioma);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
