package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;

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
