package Agency.Models;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "guests")
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ordersId")
    private Orders order;
}
