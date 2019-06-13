package com.tommy.chat.controller;

import com.tommy.chat.models.Message;
import com.tommy.chat.repository.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class WSChatController {


    private final ChatRepo repo;
    private final RestTemplate restTemplate;

    @Autowired
    public WSChatController(ChatRepo repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }


    @MessageMapping("/chat.{sessionId}")
    @SendTo("/reply/chat.{sessionId}")
    public Message sendPersonalMessage(@DestinationVariable("sessionId") String id , Message message){
        message.setDate();
        this.repo.save(message);
        sendMessageToLobbyService(message);
        System.out.println("[Message received] : " + message.toString());
        return message;
    }

    private void sendMessageToLobbyService(Message message){
        restTemplate.postForEntity("http://lobby-service/handlechatmessage", message, Void.class);

    }
}
