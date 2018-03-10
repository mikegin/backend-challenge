package adaChat.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conversation {
    private UUID conversationId;
    private List<Message> messages;
    private List<User> users;

    public Conversation() {
        conversationId = UUID.randomUUID();
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Conversation(UUID conversationId) {
        this.conversationId = conversationId;
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> members) {
        this.users = members;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void addUser(User user) { this.users.add(user); }

    public boolean hasUser(String userName) {
        for(User user: users) {
            if(user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
