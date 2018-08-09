package by.itacademy.service;

import by.itacademy.entity.Seance;

import java.sql.Date;
import java.util.List;

public interface SeanceService {
    List<Seance> getAllSeancesForPeriod(Date firstDate, Date secondDate);
    List<Seance> getAllSeancesByFilmTitle(String filmTitle);
    List<Seance> getAllSeancesByDate(Date date);

}
