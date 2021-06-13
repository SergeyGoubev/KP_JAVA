package Agency.DAO;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.Category;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Data
@Transactional
public class CategoryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Category getById(int id) {
        try {
            return (Category) entityManager.createQuery("SELECT category FROM category category WHERE category.id = :id")
                .setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }

    public Category getByName(String name) {
        return (Category) entityManager.createQuery("SELECT category FROM category WHERE category.name =:name")
            .setParameter("name", name)
            .getSingleResult();
    }
}
