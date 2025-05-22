package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}


