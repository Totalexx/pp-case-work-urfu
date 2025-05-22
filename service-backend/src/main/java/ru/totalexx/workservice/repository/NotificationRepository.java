package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

