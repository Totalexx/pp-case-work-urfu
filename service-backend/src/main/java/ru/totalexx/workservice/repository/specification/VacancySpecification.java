package ru.totalexx.workservice.repository.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.totalexx.workservice.model.Vacancy;
import ru.totalexx.workservice.repository.model.VacancyFilter;

import java.util.Objects;

public interface VacancySpecification {

    static Specification<Vacancy> filter(VacancyFilter filter) {
        return (root, query, cb) -> {
            Predicate p = cb.conjunction();

            if (Objects.nonNull(filter.getTitle())) {
                p = cb.and(p, cb.like(cb.lower(root.get("title")), "%" + filter.getTitle().toLowerCase() + "%"));
            }
            if (Objects.nonNull(filter.getMinSalary())) {
                p = cb.and(p, cb.ge(root.get("salary"), filter.getMinSalary()));
            }
            if (Objects.nonNull(filter.getMaxSalary())) {
                p = cb.and(p, cb.le(root.get("salary"), filter.getMaxSalary()));
            }
            if (Objects.nonNull(filter.getLocationStarts())) {
                p = cb.and(p, cb.like(cb.lower(root.get("location")), filter.getLocationStarts().toLowerCase() + "%"));
            }

            return p;
        };
    }
}
