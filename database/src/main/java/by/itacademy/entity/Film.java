package by.itacademy.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private LocalDate realiseDate;

    @Column(name = "description")
    private String description;

    @Column(name = "country", nullable = false)
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

    @ManyToMany
    @JoinTable(
            name = "films_has_cast_members",
            joinColumns = @JoinColumn(name = "films_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_members_id")
    )
    private Set<CastMember> castMembers = new HashSet<>();

    @OneToMany(mappedBy = "film")
    private Set<Seance> seances = new HashSet<>();

}
