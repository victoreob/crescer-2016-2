package br.com.cwi.crescer.aula05;

import DAO.AbstractDao;
import Entity.Elenco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Victor
 */
@Stateless
public class ElencoBean extends AbstractDao<Elenco, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ElencoBean() {
        super(Elenco.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Elenco> findAll() {
        return this.getEntityManager().createQuery("select e from Elenco e").getResultList();
    }
 
}
