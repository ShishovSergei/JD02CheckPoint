package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
@DiscriminatorValue("ACTOR")
public class Actor extends CastMember {

    @Column(name = "understudy")
    private String understudy;
}
