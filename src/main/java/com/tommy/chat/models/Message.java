package com.tommy.chat.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chatroomIdentifier;

    private String content;
    private String sender;
    private Date time;
    private String mediaURL;

    @ManyToOne
    @JoinTable(name = "replymessages")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Message isReplyTo;

    @Override
    public String toString() {
        return time + ": " + chatroomIdentifier + ": " + sender + ": " + content;
    }

    public void setDate() {
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.time = new Date();
    }
}
