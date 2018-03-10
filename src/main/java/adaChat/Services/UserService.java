package adaChat.Services;

import adaChat.Entities.User;
import adaChat.Exceptions.EntityExistsException;
import adaChat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(String userName) throws EntityExistsException {
        //check if user exists
        if(userRepository.getUser(userName) != null) {
            throw new EntityExistsException("User " + userName + " already exists.");
        }

        User user = new User(userName);
        userRepository.addUser(user);
    }
}
