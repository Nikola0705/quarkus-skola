
package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import model.Ucenik;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UcenikRepository implements PanacheRepository<Ucenik> {
    @Transactional
    public void persistUcenik(Ucenik ucenik) {
        persist(ucenik);
    }

    public Ucenik findById(Long id) {
        return find("id", id).firstResult();
    }
}
