/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author victor.eduardo
 */
@Entity
@Table(name = "FILME")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_FILME")
    private Long id;

    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;

    @ManyToOne
    @Basic(optional = false)
    private List<Genero> genero;

    @Basic(optional = false)
    @Column(name = "DIRETOR")
    private String diretor;

    @Basic(optional = false)
    @Column(name = "DATA_LANCAMENTO")
    private String lancamento;

    @ManyToOne
    @Basic(optional = false)
    private List<Elenco> elenco;

    @ManyToOne
    @Basic(optional = false)
    private List<Classificacao> classificacao;

    @ManyToOne
    @Basic(optional = false)
    private List<Idioma> idioma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Genero> getGenero() {
        return genero;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public List<Elenco> getElenco() {
        return elenco;
    }

    public void setElenco(List<Elenco> elenco) {
        this.elenco = elenco;
    }

    public List<Classificacao> getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(List<Classificacao> classificacao) {
        this.classificacao = classificacao;
    }

    public List<Idioma> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<Idioma> idioma) {
        this.idioma = idioma;
    }

    
    
    }
