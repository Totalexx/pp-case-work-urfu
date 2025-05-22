package ru.totalexx.workservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.workservice.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}


