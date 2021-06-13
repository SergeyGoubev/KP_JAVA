package Agency.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.Service;
import org.springframework.stereotype.Repository;


@Repository
public class ServicesDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //Получение сервисов по id юзера
    public List<Service> getServicesById(int userId) {
        try {
            return entityManager.createQuery("SELECT service FROM services service WHERE service.user.userId =:userId")
                .setParameter("userId", userId)
                .getResultList();
        } catch(Exception e) {
            return new ArrayList<>();
        }
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