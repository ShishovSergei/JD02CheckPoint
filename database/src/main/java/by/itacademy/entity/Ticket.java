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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
