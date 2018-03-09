package adaChat.Services;

import adaChat.DTOs.ConversationDTO;
import adaChat.Entities.Conversation;
import adaChat.Entities.User;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Repositories.ConversationRepository;
import adaChat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConversationService {

    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    UserRepository userRepository;

    public ConversationDTO getConversation(UUID conversationId) {
        Conversation conversation = conversationRepository.getConversation(conversationId);

        ConversationDTO conversationDTO = new ConversationDTO();
        conversationDTO.setConversationId(conversation.getConversationId());
        conversationDTO.setMessages(conversation.getMessages());

        return conversationDTO;
    }

    public UUID createConversation(Conversation conversation) throws EntityNotFoundException {
        //check if all members exist
        for(User user: conversation.getMembers()) {
            if(userRepository.getUser(user.getUserName()) == null) {
                throw new EntityNotFoundException("User: " + user.getUserName() + " does not exist.");
            }
        }

        conversationRepository.addConversation(conversation);
        return conversation.getConversationId();
    }
}