package com.umc.accountbook.service;

import com.umc.accountbook.domain.DailyConsumption;
import com.umc.accountbook.mapper.DailyConsumptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyConsumptionService {
    private final DailyConsumptionMapper dailyConsumptionMapper;

    public DailyConsumption getDailyConsumption(String user_id, String date){
        return dailyConsumptionMapper.getDailyConsumption(user_id, date);
    }
}
