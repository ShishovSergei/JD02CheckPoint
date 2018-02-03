package by.itacademy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film_genres")
public class FilmGenre extends BaseEntity{

    @Column(name = "genre", nullable = false)
    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Set<Film> films = new HashSet<>();

    public FilmGenre(String genre) {
        this.genre = genre;
    }
}
