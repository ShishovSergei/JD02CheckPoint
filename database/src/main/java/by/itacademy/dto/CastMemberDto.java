package by.itacademy.dto;

import by.itacademy.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CastMemberDto {
    private String gender;
    private String name;
    private String surname;
    private int perPage;
    private int page;

    public CastMemberDto(String gender, String name, String surname, int perPage, int page) {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.perPage = perPage;
        this.page = page;
    }
}
