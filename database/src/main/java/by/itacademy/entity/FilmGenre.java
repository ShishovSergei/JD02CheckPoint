package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "film_genres")
public class FilmGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genre", nullable = false)
    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Set<Film> films = new HashSet<>();

    public FilmGenre(String genre) {
        this.genre = genre;
    }
}
