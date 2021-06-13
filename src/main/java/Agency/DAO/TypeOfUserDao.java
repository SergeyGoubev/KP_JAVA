package Agency.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Agency.Models.TypeOfUser;
import lombok.Data;

@Data
public class TypeOfUserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public TypeOfUser getUser() {
        return (TypeOfUser) entityManager.createQuery("SELECT typeofuser FROM typeofuser typeofuser WHERE typeofuser.typeOfUser = 1").getSingleResult();
    }

    public TypeOfUser getOrganizator() {
        return (TypeOfUser) entityManager.createQuery("SELECT typeofuser FROM typeofuser typeofuser WHERE typeofuser.typeOfUser = 2").getSingleResult();
    }
}
