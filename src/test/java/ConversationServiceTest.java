import adaChat.DTOs.ConversationDTO;
import adaChat.Entities.Conversation;
import adaChat.Entities.User;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Repositories.ConversationRepository;
import adaChat.Repositories.UserRepository;
import adaChat.Services.ConversationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ConversationServiceTest {
    @Mock
    private ConversationRepository conversationRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ConversationService conversationService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGetConversationNotFound() throws Exception {
        //Arrange
        UUID conversationId = UUID.randomUUID();
        when(conversationRepository.getConversation(conversationId)).thenReturn(null);

        //Act
        conversationService.getConversation(conversationId);

    }

    @Test
    public void testGetConversationFound() throws Exception {
        //Arrange
        UUID conversationId = UUID.randomUUID();
        Conversation conversation = new Conversation();
        conversation.setConversationId(conversationId);
        when(conversationRepository.getConversation(conversationId)).thenReturn(conversation);

        //Act
        ConversationDTO conversationDTO = conversationService.getConversation(conversationId);

        //Assert
        Assert.assertEquals(conversationDTO.getConversationId(), conversation.getConversationId());

    }

    @Test(expected = EntityNotFoundException.class)
    public void testCreateConversationUserNotFound() throws Exception {
        //Arrange
        User user = new User("Sam");
        Conversation conversation = new Conversation();
        conversation.addUser(user);
        when(userRepository.getUser(user.getUserName())).thenReturn(null);

        //Act
        conversationService.createConversation(conversation);

    }

    @Test
    public void testCreateConversationUserFound() throws Exception {
        //Arrange
        User user = new User("Sam");
        Conversation conversation = new Conversation();
        conversation.addUser(user);
        when(userRepository.getUser(user.getUserName())).thenReturn(user);
        doNothing().when(conversationRepository).addConversation(conversation);

        //Act
        UUID conversationId = conversationService.createConversation(conversation);

        //Assert
        Assert.assertEquals(conversationId, conversation.getConversationId());

    }


}
