package by.itacademy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "film_format")
public class FilmFormat extends BaseEntity {

    @Column(name = "format", nullable = false)
    private String format;

    @OneToMany(mappedBy = "filmFormat")
    private Set<Seance> seances = new HashSet<>();

    public FilmFormat(String format) {
        this.format = format;
    }
}
