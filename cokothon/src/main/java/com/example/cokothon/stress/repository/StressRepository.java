package com.example.cokothon.stress.repository;

import com.example.cokothon.stress.entity.Stress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StressRepository extends JpaRepository<Stress, Long> {
    @Query("SELECT s FROM Stress s WHERE s.member.member_id = :memberId")
    List<Stress> findByMemberId(Long memberId);
}
