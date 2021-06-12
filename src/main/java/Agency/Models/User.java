package Agency.Models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String surname;

    private int age;

    private String telephone;

    private String Wishes;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    private String description;

    @ManyToOne
    @JoinColumn(name = "typeOfUser")
    private TypeOfUser typeOfUser;

    private String login;

    private String password;

    private String email;

    private float rating;

    private byte[] image;

    private String address;

    private String organizationName;

    @Override
    public String toString() {
        return "ФИО: " + name + surname + "\n" + "Телефон: " + telephone;
    }
}
