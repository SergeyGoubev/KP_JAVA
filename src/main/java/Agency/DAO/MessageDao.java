package Agency.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.Message;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Data
@Repository
@Transactional
public class MessageDao {
    @PersistenceContext
    private EntityManager entityManager;

    //Добавление нового сообщения
    public void add(Message message) {
        entityManager.merge(message);
    }


    //Получение всех сообщений по ID организатору
    public List<Message> getAllMessagesOfOrganizator(int id) {
        return entityManager.createQuery("SELECT message FROM messages message WHERE message.organizator.userId =: id")
            .setParameter("id", id)
            .getResultList();
    }
}
