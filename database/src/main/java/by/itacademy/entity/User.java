package by.itacademy.entity;

import by.itacademy.enums.UserType;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
