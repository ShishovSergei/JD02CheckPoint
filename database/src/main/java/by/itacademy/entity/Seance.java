package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "seances")
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "halls_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "film_format_id")
    private FilmFormat filmFormat;

    @ManyToOne
    @JoinColumn(name = "films_id")
    private Film film;

    @OneToMany(mappedBy = "seance")
    private Set<Ticket> tickets = new HashSet<>();

    public Seance(LocalDate date, LocalTime time, Hall hall, FilmFormat filmFormat) {
        this.date = date;
        this.time = time;
        this.hall = hall;
        this.filmFormat = filmFormat;
    }
}
