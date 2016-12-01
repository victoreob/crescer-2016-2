package br.com.cwi.crescer.aula05;

import Entity.Classificacao;
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
public class CadastroClassificacao {

    @EJB
    private ClassificacaoBean classificacaoBean;
    
    private Classificacao classificacao;
    private List<Classificacao> classificacoes;

    @PostConstruct
    public void init() {
        this.classificacao = new Classificacao();
        this.classificacoes = classificacaoBean.findAll();
        //this.classificacao.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public void adicionar() {
        classificacaoBean.insert(classificacao);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
