/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula05;

/**
 *
 * @author victor.eduardo
 */
public class Pessoa {

    private String nome;
    private String sobrenome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        if(nome == null || sobrenome == null
                || (nome.equals("") && sobrenome.equals(""))){
            return null;
        }                           
        return "O nome é " + nome + " e o sobrenome é " + sobrenome;
    }

}
