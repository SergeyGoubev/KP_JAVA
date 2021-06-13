package Agency.DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.CommentRating;
import Agency.Models.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Data
@Repository
@Transactional
@RequiredArgsConstructor
public class CommentRatingDAO {
    @PersistenceContext
    private EntityManager entityManager;


    //Сохранение нового коммента в базу данных
    public int add(CommentRating commentRating) {
        try {
            return entityManager.merge(commentRating).getId();
        } catch(Exception e) {
            return -1;
        }

    }

    public void deleteComment(User user, User organizator) {
        try {
            CommentRating comment = (CommentRating) entityManager.createQuery("SELECT comment FROM commentrating comment WHERE comment.user =:user AND comment.organizator =:organizator")
                .setParameter("user", user)
                .setParameter("organizator", organizator)
                .getSingleResult();
            entityManager.remove(comment);
        } catch(Exception e) {

        }
    }

    //Получение оценки по юзеру и организатору
    public int getMark(int orgId, int userId) {
        try {
            return (int) entityManager.createQuery(
                "SELECT commentrating.mark FROM commentrating commentrating " +
                    "WHERE commentrating.user.userId = :userId AND commentrating.organizator.userId = :orgId")
                .setParameter("userId", userId)
                .setParameter("orgId", orgId)
                .getSingleResult();
        } catch(Exception e) {
            return -1;
        }
    }


    //Получение рейтинга по ID организатора
    public BigDecimal getRating(int orgId) {
        try {
            String query = "select sum(mark)/count(*) as rating from commentrating where organizatorId="+orgId;
            return (BigDecimal) entityManager.createNativeQuery(query).getSingleResult();
        } catch(Exception e) {
            return new BigDecimal(0);
        }
    }

    //Получение всех записей у которых organizatorId = параметру orgId
    public List<CommentRating> getCommentsByOrgId(int orgId) {
        try {
            return (List<CommentRating>) entityManager.createQuery("SELECT commentrating FROM commentrating commentrating " +
                "WHERE commentrating.organizator.userId =:orgId ORDER BY commentrating.date DESC")
                .setParameter("orgId", orgId)
                .getResultList();
        } catch(Exception e) {
            return new ArrayList<>();
        }
    }
}
