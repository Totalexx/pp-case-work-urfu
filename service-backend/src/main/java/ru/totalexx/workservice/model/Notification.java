package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import ru.totalexx.workservice.model.enums.NotificationType;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification extends AbstractModel {

    @Column
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @Column
    private boolean isRead;

    @Column
    @CreationTimestamp
    private LocalDateTime timestamp;
}
