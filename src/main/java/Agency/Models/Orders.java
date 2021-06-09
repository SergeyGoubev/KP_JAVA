package Agency.Models;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "organizatorId")
    private User organizator;

    private LocalDateTime date;

    private String description;

    private String status;
}
