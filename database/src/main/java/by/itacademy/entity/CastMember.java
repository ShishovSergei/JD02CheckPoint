package by.itacademy.entity;

import by.itacademy.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cast_members")
public class CastMember extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender", nullable = false)
    private Gender gender;
}
