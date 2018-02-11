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
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "tickets")
public class Ticket extends BaseEntity {

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

    public Ticket(Float price, int place, User user) {
        this.price = price;
        this.place = place;
        this.user = user;
    }

}
