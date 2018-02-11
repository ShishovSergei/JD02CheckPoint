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
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "cinemas")
public class Cinema extends BaseEntity{

    @Embedded
    private Address address;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "cinema")
    private Set<Hall> halls = new HashSet<>();

    public Cinema(Address address, String name, String description) {
        this.address = address;
        this.name = name;
        this.description = description;
    }
}
