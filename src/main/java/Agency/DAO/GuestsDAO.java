package Agency.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.Guest;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class GuestsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //Получение списка гостей по ID юзера
    public List<Guest> getGuestsById(int userId) {
        return entityManager.createQuery("SELECT guest FROM guests guest WHERE guest.user.userId =:userId")
            .setParameter("userId", userId)
            .getResultList();
    }


    //Добавление нового гостя в базу данных
    public int add(Guest guest) {
        try {
            return entityManager.merge(guest).getId();
        } catch(Exception e) {
            return -1;
        }

    }

    //Удаление сущности гостя с указанным ID
    public int delete(int id) {
        try {
            Guest guest = (Guest) entityManager.createQuery("SELECT guest FROM guests guest WHERE guest.id =: id")
                .setParameter("id", id)
                .getSingleResult();
            entityManager.remove(guest);
            return 1;
        } catch(Exception e) {
            return -1;
        }
    }
}
