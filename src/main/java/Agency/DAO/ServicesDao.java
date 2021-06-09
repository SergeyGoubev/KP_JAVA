package Agency.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.Service;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ServicesDao {
    @PersistenceContext
    private EntityManager entityManager;

    //Получение сервисов по id юзера
    public List<Service> getServicesById(int userId) {
        return entityManager.createQuery("SELECT service FROM services service WHERE service.user.userId =:userId")
            .setParameter("userId", userId)
            .getResultList();
    }


    //Получение всех сервисов
    public List<Service> getAllServices() {
        return entityManager.createQuery("SELECT service FROM services service")
            .getResultList();
    }


    //Добавление сервиса
    public void add(Service service) {
        entityManager.merge(service);
    }

    //Удаление сервиса по ID
    public void delete(int id) {
        Service service = (Service) entityManager.createQuery("SELECT service FROM services service WHERE service.id =:id")
            .setParameter("id", id)
            .getSingleResult();
        entityManager.remove(service);
    }
}
