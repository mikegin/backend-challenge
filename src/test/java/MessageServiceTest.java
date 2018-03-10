import adaChat.DTOs.MessageDTO;
import adaChat.Entities.Conversation;
import adaChat.Entities.User;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Repositories.ConversationRepository;
import adaChat.Repositories.UserRepository;
import adaChat.Services.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.when;

public class MessageServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ConversationRepository conversationRepository;

    @InjectMocks
    MessageService messageService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = EntityNotFoundException.class )
    public void testCreateMessageUserNotFound() throws Exception {
        //Arrange
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSender("Sam");
        when(userRepository.getUser(messageDTO.getSender())).thenReturn(null);

        //Act
        messageService.createMessage(messageDTO);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testCreateMessageUserNotInConvo() throws Exception {
        //Arrange
         MessageDTO messageDTO = new MessageDTO();

         User user = new User("Sam");
         messageDTO.setSender(user.getUserName());

         UUID conversationId = UUID.randomUUID();
         messageDTO.setConversationId(conversationId);

         Conversation conversation = new Conversation();
         conversation.setConversationId(conversationId);

         when(userRepository.getUser(messageDTO.getSender())).thenReturn(user);
         when(conversationRepository.getConversation(messageDTO.getConversationId())).thenReturn(conversation);

         //Act
        messageService.createMessage(messageDTO);

    }
}
