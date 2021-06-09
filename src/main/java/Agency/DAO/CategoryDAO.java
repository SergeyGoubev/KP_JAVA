package Agency.DAO;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.Category;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class CategoryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Category getById(int id) {
        return (Category) entityManager.createQuery("SELECT category FROM category category WHERE category.id = :id")
            .setParameter("id", id).getSingleResult();
    }
}
