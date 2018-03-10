import adaChat.Entities.User;
import adaChat.Exceptions.EntityExistsException;
import adaChat.Repositories.UserRepository;
import adaChat.Services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = EntityExistsException.class)
    public void testAddUserAlreadyExists() throws Exception {
        //Arrange
        User user = new User("Tom");
        when(userRepository.getUser(user.getUserName())).thenReturn(user);

        //Act
        userService.addUser(user);
    }
}
