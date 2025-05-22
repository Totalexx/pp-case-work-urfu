package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.VacancyResponse;

@Repository
public interface VacancyResponseRepository extends JpaRepository<VacancyResponse, Long> {
}


