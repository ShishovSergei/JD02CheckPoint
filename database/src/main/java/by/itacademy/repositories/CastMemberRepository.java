package by.itacademy.repositories;

import by.itacademy.entity.CastMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CastMemberRepository extends CrudRepository<CastMember, Integer> {

    List<CastMember> findCastMembersByGender(String gender);
    List<CastMember> findCastMembersByNameAndSurname(String name, String surname);
}
