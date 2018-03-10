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
        String userName = "Tom";
        when(userRepository.getUser(userName)).thenReturn(new User(userName));

        //Act
        userService.addUser(userName);
    }
}
