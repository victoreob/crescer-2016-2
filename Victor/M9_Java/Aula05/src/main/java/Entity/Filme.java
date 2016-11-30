/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author victor.eduardo
 */

@Entity
@Table(name="FILME")
public class Filme implements Serializable{
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_FILME")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    
    @OneToMany
    @Basic(optional = false)
    @Column(name = "GENERO")
    private Genero genero;
    
    @Basic(optional = false)
    @Column(name = "DIRETOR")
    private String diretor;
    
    @Basic(optional = true)
    @Column(name = "DATA_LANCAMENTO")
    private Date lancamento;
    
    @OneToMany
    @Basic(optional = false)
    @Column(name = "ELENCO")
    private Elenco elenco;
    
    @OneToMany
    @Basic(optional = false)
    @Column(name = "CLASSIFICACAO")
    private Classificacao classificacao;
    
    @OneToMany
    @Basic(optional = false)
    @Column(name = "IDIOMA")
    private Idioma idioma;

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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
    
    
}
