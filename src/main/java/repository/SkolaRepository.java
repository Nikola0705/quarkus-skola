package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Skola;

import java.util.List;

@ApplicationScoped
public class SkolaRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createSkola(Skola skola) {
        em.persist(skola);
    }

    public List<Skola> getAllSkole() {
        return em.createQuery("SELECT s FROM Skola s", Skola.class).getResultList();
    }
}