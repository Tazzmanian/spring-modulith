package com.tazz.modulith.demo.eventaction;

import com.tazz.modulith.demo.eventaction.action.Action;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(indexes = {
    @Index(name = "actionId", columnList = "action")
})
public class EventAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2, nullable = false)
    private Action action;
    @Column(name = "event_can", nullable = false)
    private String eventCanonicalName;
}
