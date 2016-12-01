package br.com.cwi.crescer.aula05;

import DAO.AbstractDao;
import Entity.Idioma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Victor
 */
@Stateless
public class IdiomaBean extends AbstractDao<Idioma, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public IdiomaBean() {
        super(Idioma.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Idioma> findAll() {
        return this.getEntityManager().createQuery("select i from Idioma i").getResultList();
    }
 
}
