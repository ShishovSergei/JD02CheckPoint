package by.itacademy.entity;

import by.itacademy.enums.UserType;
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
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets = new HashSet<>();

    public User(String login, String password, String email, UserType type) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.type = type;
    }
}
