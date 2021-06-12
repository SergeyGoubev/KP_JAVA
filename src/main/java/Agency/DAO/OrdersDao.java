package Agency.DAO;

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
}
