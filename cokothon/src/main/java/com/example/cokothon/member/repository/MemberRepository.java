package com.example.cokothon.member.repository;

import com.example.cokothon.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
    Optional<Member> findByNickname(String nickname);

    @Query("SELECT m FROM Member m where m.member_id = :memberId")
    Optional<Member> findByMember_id(String memberId);

}
