package by.itacademy.entity;


import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {
    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;
}
