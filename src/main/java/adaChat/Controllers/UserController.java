package adaChat.Controllers;

import adaChat.Exceptions.EntityExistsException;
import adaChat.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody String userName) throws EntityExistsException {
        userService.addUser(userName);
    }
}
