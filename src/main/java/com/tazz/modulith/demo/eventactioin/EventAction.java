package com.tazz.modulith.demo.eventactioin;

import com.tazz.modulith.demo.eventactioin.action.Action;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(indexes = {

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
