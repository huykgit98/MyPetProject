package org.maks.service;

import org.maks.domain.Vacancy;
import org.maks.dto.VacancyDto;
import org.maks.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    public Vacancy dtoToDomain(VacancyDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("vacancy dto is null");
        }
        Vacancy vacancy = new Vacancy();
        vacancy.setDescription(dto.getDescription());
        vacancy.setGuid(dto.getGuid());
        vacancy.setLink(dto.getLink());
        vacancy.setTitle(dto.getTitle());
        vacancy.setPubDate(dto.getPubDate());
        if (vacancy.getDateSaved() == null) {
            vacancy.setDateSaved(new Date());
        }
        return vacancy;
    }

    public List<Vacancy> dtoToDomain(List<VacancyDto> vacancyDtos) {
        List<Vacancy> vacancies = new ArrayList<>();
        for (VacancyDto vacancyDto : vacancyDtos) {
            vacancies.add(dtoToDomain(vacancyDto));
        }
        return vacancies;
    }

    public List<Vacancy> checkUnique(List<Vacancy> vacancies) {
        List<Vacancy> vacanciesFromDb = vacancyRepository.findByDateSavedAfter(getMeYesterday());
        return vacancies.stream().filter(vacanciesFromDb::contains).collect(Collectors.toList());

    }

    private Date getMeYesterday(){
        return new Date(System.currentTimeMillis()-24*60*60*1000);
    }
}
