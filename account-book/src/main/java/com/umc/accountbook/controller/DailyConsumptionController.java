package com.umc.accountbook.controller;

import com.umc.accountbook.domain.DailyConsumption;
import com.umc.accountbook.domain.EssentialSpending;
import com.umc.accountbook.service.DailyConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;
import java.lang.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("daily-consumption")
public class DailyConsumptionController {

    private final DailyConsumptionService dailyConsumptionService;

    @GetMapping ("/check")
    public ResponseEntity<String> getTodaySuccess(@RequestParam String id, @RequestParam String date){
        return ResponseEntity.ok(dailyConsumptionService.getTodaySuccess(id, date));
    }
    //http://url/check?id=1&date=2023-01-01

    @GetMapping("daily-consumption/{user_id}")
    public DailyConsumption getDailyConsumption(@PathVariable long user_id){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        //test용
        DailyConsumption dailyConsumption = dailyConsumptionService.getDailyConsumption(String.valueOf(user_id), "2023-01-01");
        //DailyConsumption dailyConsumption = dailyConsumptionService.getDailyConsumption(String.valueOf(user_id), formatter.format(date));
        return dailyConsumption;
    }
}