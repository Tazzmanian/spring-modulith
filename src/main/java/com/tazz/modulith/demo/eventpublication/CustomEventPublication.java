package com.tazz.modulith.demo.eventpublication;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_publication")
public class CustomEventPublication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String eventType;
    private String listenerId;
    private Timestamp completionDate;
    private Timestamp publicationDate;
    private String serializedEvent;
}
