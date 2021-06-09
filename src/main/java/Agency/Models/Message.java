package Agency.Models;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "organizatorId")
    private User organizator;

    private String message;

    private LocalDateTime date;
}
