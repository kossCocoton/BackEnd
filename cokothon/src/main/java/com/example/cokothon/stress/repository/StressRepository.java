package com.example.cokothon.stress.repository;

import com.example.cokothon.stress.entity.Stress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StressRepository extends JpaRepository<Stress, Long> {
}
