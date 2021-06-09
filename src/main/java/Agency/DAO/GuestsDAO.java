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
    public void add(Guest guest) {
        entityManager.merge(guest);
    }

    //Удаление сущности гостя с указанным ID
    public void delete(int id) {
        Guest guest = (Guest) entityManager.createQuery("SELECT guest FROM guests guest WHERE guest.id =: id")
            .setParameter("id", id)
            .getSingleResult();

        entityManager.remove(guest);
    }
}
