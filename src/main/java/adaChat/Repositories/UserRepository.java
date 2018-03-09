package adaChat.Repositories;

import adaChat.Entities.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    private static HashMap<String, User> userDb = new HashMap<>();

    public void addUser(User user) {
        userDb.put(user.getUserName(), user);
    }

    public User getUser(String userName) {
        return userDb.get(userName);
    }
}
