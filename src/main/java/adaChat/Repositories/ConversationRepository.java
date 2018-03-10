package adaChat.Repositories;

import adaChat.Entities.Conversation;
import adaChat.Entities.Message;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class ConversationRepository {

    private static HashMap<UUID, Conversation> conversationDb = new HashMap<>();

    public void addConversation(Conversation conversation) {
        conversationDb.put(conversation.getConversationId(), conversation);
    }

    public Conversation getConversation(UUID conversationId) {
        return conversationDb.get(conversationId);
    }

    public void addMessage(UUID conversationId, Message message) {
        Conversation conversation = conversationDb.get(conversationId);
        conversation.addMessage(message);
    }

}
