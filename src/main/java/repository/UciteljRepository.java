package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.Ucitelj;

@ApplicationScoped
public class UciteljRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createUcitelj(Ucitelj ucitelj) {
        em.persist(ucitelj);
    }
}