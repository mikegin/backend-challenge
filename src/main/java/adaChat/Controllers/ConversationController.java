package adaChat.Controllers;

import adaChat.DTOs.ConversationDTO;
import adaChat.Entities.Conversation;
import adaChat.Exceptions.EntityNotFoundException;
import adaChat.Services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ConversationController {

    @Autowired
    ConversationService conversationService;

    @GetMapping("/conversations/{conversationId}")
    public ConversationDTO getConversation(@PathVariable UUID conversationId) {
        return conversationService.getConversation(conversationId);
    }

    @PostMapping("/conversations")
    public UUID createConversation(@RequestBody Conversation conversation) throws EntityNotFoundException {
        return conversationService.createConversation(conversation);
    }
}
