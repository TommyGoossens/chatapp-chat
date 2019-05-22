package com.tommy.chat.repository;

import com.tommy.chat.models.ChatParticipant;
import com.tommy.chat.models.ChatRoom;
import com.tommy.chat.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepo extends JpaRepository<ChatRoom, ChatParticipant> {
    Optional<List<ChatRoom>> findAllByParticipantsContaining(ChatParticipant participant);
}
