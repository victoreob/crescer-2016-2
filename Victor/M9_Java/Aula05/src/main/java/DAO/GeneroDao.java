package DAO;


import Entity.Genero;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Victor
 */
public class GeneroDao extends AbstractDao<Genero, Long> {

    final EntityManager entityManager;

    public GeneroDao(EntityManager entityManager) {
        super(Genero.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Genero> findAll() {
        return this.getEntityManager().createQuery("select g from GENERO g").getResultList();
    }
    
    
}
 