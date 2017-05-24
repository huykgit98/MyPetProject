package org.maks.service;

import org.maks.domain.Vacancy;

import java.util.Comparator;

public class VacancyComparator implements Comparator<Vacancy> {

    @Override
    public int compare(Vacancy vac1, Vacancy vac2) {
        return vac1.getGuid().compareTo(vac2.getGuid());
    }
}
