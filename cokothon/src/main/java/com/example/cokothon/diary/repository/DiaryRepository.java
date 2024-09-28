package com.example.cokothon.diary.repository;

import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @Query("select d from Diary d where d.member = :member")
    List<Diary> findAllById(Member member);

}
