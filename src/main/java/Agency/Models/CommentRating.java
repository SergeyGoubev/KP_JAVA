package Agency.Models;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "commentrating")
@Data
public class CommentRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "organizatorId")
    private User organizator;

    private int mark;

    private String comment;

    private LocalDateTime date;
}
