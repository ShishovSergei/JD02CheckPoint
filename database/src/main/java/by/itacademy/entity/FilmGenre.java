package by.itacademy.entity;


import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
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
