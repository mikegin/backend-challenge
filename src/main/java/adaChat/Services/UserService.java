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

    public void addUser(User user) throws EntityExistsException {
        //check if user exists
        if(userRepository.getUser(user.getUserName()) != null) {
            throw new EntityExistsException("User " + user.getUserName() + " already exists.");
        }

        userRepository.addUser(user);
    }
}
