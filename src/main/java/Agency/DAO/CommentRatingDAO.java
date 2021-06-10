package Agency.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.CommentRating;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
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

    //Получение оценки по юзеру и организатору
    public int getMark(int orgId, int userId) {
        return (int) entityManager.createQuery(
            "SELECT commentrating.mark FROM commentrating commentrating " +
                "WHERE commentrating.user.userId = :userId AND commentrating.organizator.userId = :orgId")
            .setParameter("userId", userId)
            .setParameter("orgId", orgId)
            .getSingleResult();
    }


    //Получение рейтинга по ID организатора
    public float getRating(int orgId) {
        String query = "select sum(mark)/count(*) as rating from commentrating where organizatorId="+orgId;
        return (float) entityManager.createNativeQuery(query).getSingleResult();
    }

    //Получение всех записей у которых organizatorId = параметру orgId
    public List<CommentRating> getCommentsByOrgId(int orgId) {
        return (List<CommentRating>) entityManager.createQuery("SELECT commentrating FROM commentrating commentrating " +
            "WHERE commentrating.organizator.userId =:orgId ORDER BY commentrating.date DESC")
            .setParameter("orgId", orgId)
            .getSingleResult();
    }
}
