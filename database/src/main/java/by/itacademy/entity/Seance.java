package by.itacademy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
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
public class Seance extends BaseEntity {

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "age_limit")
    private String ageLimit;

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

    public Seance(Date date, LocalTime time, Hall hall, FilmFormat filmFormat) {
        this.date = date;
        this.time = time;
        this.hall = hall;
        this.filmFormat = filmFormat;
    }

    public Seance(Date date, LocalTime time) {
        this.date = date;
        this.time = time;

    }

    public Seance(Date date, LocalTime time, String ageLimit) {
        this.date = date;
        this.time = time;
        this.ageLimit = ageLimit;
    }
}
