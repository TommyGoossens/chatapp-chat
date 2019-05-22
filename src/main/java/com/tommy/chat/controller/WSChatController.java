package com.tommy.chat.controller;

import com.tommy.chat.models.TextMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WSChatController {

    @MessageMapping("/chat.personal.1")
    @SendTo("/topic/personal.1")
    public TextMessage sendPersonalMessage(TextMessage message){
        return message;
    }
}
