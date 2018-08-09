package by.itacademy.repositories;

import by.itacademy.entity.Seance;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SeanceRepositoryImpl implements SeanceRepositoryCustom {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public SeanceRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Seance> findSeanceByFilmTitle(String title) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select s from Seance s where s.film.title=:title")
                .setParameter("title", title)
                .getResultList();

    }
}
