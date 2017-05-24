package org.maks.repository;

import org.maks.domain.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.Date;
import java.util.List;

public interface VacancyRepository extends MongoRepository<Vacancy, String> {
    List<Vacancy> findTop100ByOrderById();
    List<Vacancy> findByDateSavedAfter(Date date);
}
