package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
}
