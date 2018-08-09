package by.itacademy.repositories;

import by.itacademy.entity.User;
import by.itacademy.enums.UserType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findUsersByType(UserType type);
    User findUserByEmail(String email);
    User findUserbyLogin(String login);
}
