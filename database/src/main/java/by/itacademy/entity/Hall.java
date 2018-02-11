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
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "halls")
public class Hall extends BaseEntity{

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "cinemas_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "hall")
    private Set<Seance> seances = new HashSet<>();

    public Hall(int capacity) {
        this.capacity = capacity;
    }

    public Hall(int capacity, Cinema cinema) {
        this.capacity = capacity;
        this.cinema = cinema;
    }
}
