package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}


