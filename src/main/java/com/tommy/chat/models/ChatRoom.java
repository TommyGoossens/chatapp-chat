package com.tommy.chat.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {
    private ChatParticipant creator;
    private List<Message> messages;
    private List<ChatParticipant> participants;
}
