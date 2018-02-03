package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;

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
