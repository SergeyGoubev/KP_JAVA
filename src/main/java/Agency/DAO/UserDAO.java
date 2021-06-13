package Agency.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Data
@RequiredArgsConstructor
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private final CommentRatingDAO commentRatingDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Добавление нового пользователя
    @Transactional
    public int add(User user) {
       // try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return entityManager.merge(user).getUserId();
        //} catch(Exception e) {
          //  return -1;
        //}
    }

    //Получение всех пользователей заданной категории
    @Transactional
    public List<User> getByCategory(int category) {
        List<User> users = entityManager.createQuery("SELECT user FROM user user WHERE user.category.id =:category")
            .setParameter("category", category)
            .getResultList();

       // users.forEach(item -> item.setRating(commentRatingDAO.getRating(item.getUserId()).floatValue()));
        return users;
    }


    @Transactional
    public User getByLogin(String login) {
        return (User) entityManager.createQuery("SELECT user FROM user user WHERE user.login =:login")
            .setParameter("login", login)
            .getSingleResult();
    }

    //Получение пользователя по ID
    @Transactional
    public User getById(int userId) {
        return (User) entityManager.createQuery("SELECT user FROM user user WHERE user.userId = :userId")
            .setParameter("userId", userId)
            .getSingleResult();
    }


    //Получение аватарки пользователя
    @Transactional
    public byte[] getUserImage(int userId) {
        return (byte[]) entityManager.createQuery("SELECT user.image FROM user user WHERE user.userId =: userId")
            .setParameter("userId", userId)
            .getSingleResult();
    }
}
