package br.com.cwi.crescer.aula05;

import DAO.AbstractDao;
import Entity.Filme;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Victor
 */
@Stateless
public class FilmeBean extends AbstractDao<Filme, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public FilmeBean() {
        super(Filme.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Filme> findAll() {
        return this.getEntityManager().createQuery("select f from FILME f").getResultList();
    }
 
}
