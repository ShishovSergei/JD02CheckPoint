package by.itacademy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "directors")
@PrimaryKeyJoinColumn(name = "cast_members_id")
public class Director extends CastMember {
    @Column(name = "studio", nullable = false)
    private String studio;
}
