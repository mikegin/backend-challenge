package adaChat.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conversation {
    private UUID conversationId;
    private List<Message> messages;
    private List<User> members;

    public Conversation() {
        conversationId = UUID.randomUUID();
        this.messages = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public Conversation(UUID conversationId) {
        this.conversationId = conversationId;
        this.messages = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<User> getMembers() { return members; }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public boolean hasUser(String userName) {
        for(User user: members) {
            if(user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
