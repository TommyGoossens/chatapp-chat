package com.tommy.chat.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private String time;
    private String mediaURL;

    @ManyToOne
    @JoinTable(name = "replymessages")
//    @JoinColumn(name="original_message_id", referencedColumnName = "id")
//    @JoinColumn(name="reply_message_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Message isReplyTo;

    @Override
    public String toString() {
        return time + ": " + chatroomIdentifier + ": " + sender + ": " + content;
    }

    public void setDate() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        this.time = dateFormat.format(date);
    }
}
