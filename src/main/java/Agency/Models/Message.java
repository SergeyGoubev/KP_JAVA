package Agency.Models;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private int userId;
    private int organizatorId;
    private String message;
    private LocalDateTime data;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrganizatorId() {
        return organizatorId;
    }

    public void setOrganizatorId(int organizatorId) {
        this.organizatorId = organizatorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
