package adaChat.Controllers;

import adaChat.DTOs.MessageDTO;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/messages")
    public void createMessage(@RequestBody MessageDTO messageDTO) throws EntityNotFoundException {
        messageService.createMessage(messageDTO);
    }
}
