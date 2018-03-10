package adaChat.Controllers;

import adaChat.DTOs.MessageDTO;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/messages")
    public ResponseEntity createMessage(@RequestBody MessageDTO messageDTO) {
        try {
            messageService.createMessage(messageDTO);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
