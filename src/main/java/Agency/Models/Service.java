package Agency.Models;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "services")
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String name;

    private String description;

    private int costs;
}
