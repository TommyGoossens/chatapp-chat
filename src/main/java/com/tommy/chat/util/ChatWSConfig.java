package com.tommy.chat.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChatWSConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Register the app prefix the client sends messages to: serverurl + /app/...
     * The client can subscribe to the /reply endpoint
     * @param brokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry brokerRegistry){
        brokerRegistry.setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker("/reply");
    }

    /**
     * Register the endpoints the front end can connect to, in this case: serverurl + /chat
     * @param endpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry endpointRegistry){
        endpointRegistry.addEndpoint("/wschat")
                .setAllowedOrigins("*")
                .withSockJS();
    }
}
