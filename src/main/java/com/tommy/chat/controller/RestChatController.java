package com.tommy.chat.controller;


import com.tommy.chat.models.Message;
import com.tommy.chat.repository.ChatRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Chat")
public class RestChatController {

    private final ChatRepo chatRepo;

    @Autowired
    public RestChatController(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }


    @ApiOperation(value = "Retrieve all messages from a chat")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "All chats retrieved",response = Message.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "[Unauthorized]")
    })
    @GetMapping("/{chatsessionid}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllMessagesForChatSession(@PathVariable(value = "chatsessionid") String id) {
        List<Message> messages = chatRepo.getAllByChatroomIdentifier(id).orElse(new ArrayList<>());
        return ResponseEntity.status(200).body(messages);
    }


}
