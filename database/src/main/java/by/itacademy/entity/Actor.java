package by.itacademy.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Column;

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
