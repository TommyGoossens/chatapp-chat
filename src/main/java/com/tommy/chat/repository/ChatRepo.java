package com.tommy.chat.repository;

import com.tommy.chat.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepo extends JpaRepository<Message, Long> {
    Optional<List<Message>> getAllByChatroomIdentifier(String id);

}
