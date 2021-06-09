package Agency.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity(name = "typeofuser")
@Data
public class TypeOfUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeOfUser;

    private String description;
}
