package by.itacademy.entity;

import javafx.scene.input.DataFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "films")
public class Film extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private LocalDate realiseDate;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    public Film(String title, LocalDate realiseDate, String description, String country) {
        this.title = title;
        this.realiseDate = realiseDate;
        this.description = description;
        this.country = country;
    }

    @ManyToMany
    @JoinTable(
            name = "films_has_film_genres",
            joinColumns = @JoinColumn(name = "films_id"),
            inverseJoinColumns = @JoinColumn(name = "film_genres_id")
    )
    private Set<FilmGenre> genres = new HashSet<>();

    /*public void addFilmGenres(FilmGenre filmGenre) {
        genres.add(filmGenre);
    }*/
}
