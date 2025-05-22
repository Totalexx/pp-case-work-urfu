package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.model.VacancyResponse;

import java.util.List;

@Repository
public interface VacancyResponseRepository extends JpaRepository<VacancyResponse, Long> {
    List<VacancyResponse> findAllByResume_User(User user);
}


