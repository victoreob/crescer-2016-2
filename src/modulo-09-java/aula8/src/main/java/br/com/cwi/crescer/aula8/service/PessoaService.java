package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Iterable<Pessoa> listAll() {
        return pessoaRepository.findAll();
    }

    public void add(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

}
