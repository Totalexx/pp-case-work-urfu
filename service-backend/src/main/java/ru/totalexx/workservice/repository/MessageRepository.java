package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}


