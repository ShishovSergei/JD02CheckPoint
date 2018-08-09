package by.itacademy.service;

import by.itacademy.dao.CastMemberDao;
import by.itacademy.dto.CastMemberDto;
import by.itacademy.entity.CastMember;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CastMemberServiceImpl implements CastMemberService{
    public List<CastMember> getCastMembersByParams(CastMemberDto castMemberDto) {
        return new CastMemberDao().findCastMembersWithParams(castMemberDto);
    }

    public Long getCastMembersCount(CastMemberDto castMemberDto) {
        return new CastMemberDao().countCastMembers(castMemberDto);
    }
}
