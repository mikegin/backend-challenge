package adaChat.Controllers;

import adaChat.DTOs.ConversationDTO;
import adaChat.Entities.Conversation;
import adaChat.Exceptions.EntityExistsException;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ConversationController {

    @Autowired
    ConversationService conversationService;

    @GetMapping("/conversations/{conversationId}")
    public ResponseEntity getConversation(@PathVariable UUID conversationId) {
        ConversationDTO conversationDTO;
        try {
            conversationDTO = conversationService.getConversation(conversationId);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(conversationDTO);
    }

    @PostMapping("/conversations")
    public ResponseEntity createConversation(@RequestBody Conversation conversation) {
        UUID conversationId;
        try {
            conversationId = conversationService.createConversation(conversation);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(conversationId);
    }
}
