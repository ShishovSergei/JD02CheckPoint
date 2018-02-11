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
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "film_format")
public class FilmFormat extends BaseEntity{

    @Column(name = "format", nullable = false)
    private String format;

    @OneToMany(mappedBy = "filmFormat")
    private Set<Seance> seances = new HashSet<>();

    public FilmFormat(String format) {
        this.format = format;
    }
}
