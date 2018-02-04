package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "place", nullable = false, unique = true)
    private int place;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "seances_id")
    private Seance seance;

    public Ticket(Float price, int place, Seance seance) {
        this.price = price;
        this.place = place;
        this.seance = seance;
    }
}
