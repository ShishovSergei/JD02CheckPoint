package by.itacademy.service;

import by.itacademy.entity.Seance;
import by.itacademy.repositories.SeanceRepository;
import by.itacademy.repositories.SeanceRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class SeanceServiceImpl implements SeanceService {

    private SeanceRepository seanceRepository;
    private SeanceRepositoryCustom seanceRepositoryCustom;

    @Autowired
    public SeanceServiceImpl(SeanceRepositoryCustom seanceRepositoryCustom) {
        this.seanceRepositoryCustom = seanceRepositoryCustom;
    }

    @Autowired
    public SeanceServiceImpl(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public List<Seance> getAllSeancesForPeriod(Date firstDate, Date secondDate) {
        return seanceRepository.findSeancesByDateBetween(firstDate, secondDate);
    }

    @Override
    public List<Seance> getAllSeancesByFilmTitle(String filmTitle) {
        return seanceRepositoryCustom.findSeanceByFilmTitle(filmTitle);
    }

    @Override
    public List<Seance> getAllSeancesByDate(Date date) {
        return seanceRepository.findSeancesByDate(date);
    }
}
