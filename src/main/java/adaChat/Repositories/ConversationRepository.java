package adaChat.Repositories;

import adaChat.Entities.Conversation;
import adaChat.Entities.Message;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class ConversationRepository {

    private static HashMap<UUID, Conversation> conversationDb = new HashMap<>();
    static {
        conversationDb.put(UUID.fromString("296d5bd5-f36a-4418-9cb9-ba29a0764fe1"),
                new Conversation(UUID.fromString("296d5bd5-f36a-4418-9cb9-ba29a0764fe1")));
    }

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
