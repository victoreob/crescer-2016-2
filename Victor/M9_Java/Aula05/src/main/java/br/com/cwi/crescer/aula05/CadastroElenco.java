package br.com.cwi.crescer.aula05;

import Entity.Classificacao;
import Entity.Elenco;
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
public class CadastroElenco {

    @EJB
    private ElencoBean elencoBean;
    
    private Elenco elenco;
    private List<Elenco> elencos;

    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoBean.findAll();
        //this.elenco.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public void adicionar() {
        elencoBean.insert(elenco);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
