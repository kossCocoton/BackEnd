package com.example.cokothon.stress.service;

import com.example.cokothon.stress.dto.StressDto;
import com.example.cokothon.stress.entity.Stress;

import java.util.List;

public interface StressService {
    public Stress createStress(StressDto stressDto);

    public List<Stress> getAllStress(Long memberId);
}
