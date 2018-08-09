package by.itacademy.service;

import by.itacademy.dto.CastMemberDto;
import by.itacademy.entity.CastMember;

import java.util.List;

public interface CastMemberService {
    List<CastMember> getCastMembersByParams(CastMemberDto castMemberDto);
    Long getCastMembersCount(CastMemberDto castMemberDto);
}
