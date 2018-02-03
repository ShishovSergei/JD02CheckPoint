package by.itacademy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "halls")
public class Hall extends BaseEntity {

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "cinemas_id")
    private Cinema cinema;

    public Hall(int capacity) {
        this.capacity = capacity;
    }
}
