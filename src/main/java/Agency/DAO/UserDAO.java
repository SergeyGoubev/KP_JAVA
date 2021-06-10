package Agency.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@RequiredArgsConstructor
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private final CommentRatingDAO commentRatingDAO;

    //Добавление нового пользователя
    public int add(User user) {
        try{
             return entityManager.merge(user).getUserId();
        } catch(Exception e) {
            return -1;
        }
    }

    //Получение всех пользователей заданной категории
    public List<User> getByCategory(int category) {
        List<User> users = entityManager.createQuery("SELECT user FROM user user WHERE user.category.id =:category")
            .setParameter("category", category)
            .getResultList();

        users.forEach(item -> item.setRating(commentRatingDAO.getRating(item.getUserId())));
        return users;
    }


    //Получение пользователя по ID
    public User getById(int userId) {
        return (User) entityManager.createQuery("SELECT user FROM user user WHERE user.userId = :userId")
            .setParameter("userId", userId)
            .getSingleResult();
    }


    //Получение аватарки пользователя
    public byte[] getUserImage(int userId) {
        return (byte[]) entityManager.createQuery("SELECT user.image FROM user user WHERE user.userId =: userId")
            .setParameter("userId", userId)
            .getSingleResult();
    }
}
