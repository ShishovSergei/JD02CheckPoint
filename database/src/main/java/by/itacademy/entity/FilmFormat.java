package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "film_format")
public class FilmFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "format", nullable = false)
    private String format;

    @OneToMany(mappedBy = "filmFormat")
    private Set<Seance> seances = new HashSet<>();

    public FilmFormat(String format) {
        this.format = format;
    }
}
