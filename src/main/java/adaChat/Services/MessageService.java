package adaChat.Services;

import adaChat.DTOs.MessageDTO;
import adaChat.Entities.Conversation;
import adaChat.Entities.Message;
import adaChat.Entities.User;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Repositories.ConversationRepository;
import adaChat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    UserRepository userRepository;

    public void createMessage(MessageDTO messageDTO) throws EntityNotFoundException {
        //check if user exists
        User user = userRepository.getUser(messageDTO.getSender());
        if(user == null) {
            throw new EntityNotFoundException("User " + messageDTO.getSender() + " does not exist.");
        }

        //check if user in conversation
        Conversation conversation = conversationRepository.getConversation(messageDTO.getConversationId());
        if(!conversation.hasUser(user.getUserName())) {
            throw new EntityNotFoundException("User " + user.getUserName() + " is not part of the conversation.");
        }

        Message message = new Message(messageDTO.getSender(), messageDTO.getMessage());
        conversationRepository.addMessage(messageDTO.getConversationId(), message);
    }
}
