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
public class ChatParticipant {
    private String firstName;
    private String lastName;
    private String status;



}
