package by.itacademy;

import by.itacademy.dao.CastMemberDao;
import by.itacademy.dto.CastMemberDto;
import by.itacademy.entity.CastMember;

import java.util.List;

public class CastMemberService {
    public List<CastMember> getCastMembersByParams(CastMemberDto castMemberDto) {
        return new CastMemberDao().findCastMembersWithParams(castMemberDto);
    }

    public Long getCastMembersCount(CastMemberDto castMemberDto) {
        return new CastMemberDao().countCastMembers(castMemberDto);
    }
}
