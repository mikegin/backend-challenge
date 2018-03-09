package adaChat.DTOs;

import adaChat.Entities.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConversationDTO {
    private UUID conversationId;
    private List<Message> messages;

    public ConversationDTO() {
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
