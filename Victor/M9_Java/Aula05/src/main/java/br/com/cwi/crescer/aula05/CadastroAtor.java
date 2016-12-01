package br.com.cwi.crescer.aula05;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class Ator {

    @EJB
    private AtorBean atorBean;
    
    private Ator ator;
    private List<Ator> atores;

    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorBean.findAll();
        //this.generos.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void adicionar() {
        atorBean.insert(ator);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
