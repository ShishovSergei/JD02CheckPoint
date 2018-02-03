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
@Table(name = "actors")
@PrimaryKeyJoinColumn(name = "cast_members_id")
public class Actor extends CastMember {

    @Column(name = "understudy", nullable = false)
    private boolean understudy;
}
