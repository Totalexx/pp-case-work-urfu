package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

