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
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
