package adaChat.DTOs;

import java.util.UUID;

public class MessageDTO {
    private String sender;
    private UUID conversationId;
    private String message;

    public MessageDTO() {

    }

    public MessageDTO(String sender, UUID conversationId, String message) {
        this.sender = sender;
        this.conversationId = conversationId;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
