package by.itacademy.entity;


import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
@DiscriminatorValue("DIRECTOR")
public class Director extends CastMember {
    @Column(name = "studio")
    private String studio;
}
