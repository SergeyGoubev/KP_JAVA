package Agency.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.Orders;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Data
@RequiredArgsConstructor
@Transactional
public class OrdersDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Orders orders) {
        entityManager.merge(orders);
    }

    public List<Orders> getAllOfOrganizator(int organizatorId) {
        return entityManager.createQuery("SELECT order FROM orders order WHERE order.organizator.userId =: organizatorId")
            .setParameter("organizatorId", organizatorId).getResultList();
    }

    public List<Orders> getAllOfUser(int userId) {
        return entityManager.createQuery("SELECT order FROM orders order WHERE order.user.userId =: userId AND order.status = 'accepted'")
            .setParameter("userId", userId)
            .getResultList();
    }

    public Orders getById(int id) {
        return (Orders) entityManager.createQuery("SELECT order FROM orders order WHERE order.id =:id")
            .setParameter("id", id)
            .getSingleResult();
    }
}
