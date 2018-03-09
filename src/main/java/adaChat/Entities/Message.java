package adaChat.Entities;

import java.time.Instant;
import java.util.UUID;

public class Message {
    private String sender;
    private String message;
    private String created;

    public Message() {

    }

    public Message(String sender, String message) {
        this.sender = sender;
        this.message = message;
        this.created = Instant.now().toString();
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created.toString();
    }
}
