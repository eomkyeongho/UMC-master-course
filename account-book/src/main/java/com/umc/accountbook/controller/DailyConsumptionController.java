package com.umc.accountbook.controller;

import com.umc.accountbook.service.DailyConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("daily-consumption")
public class DailyConsumptionController {
    private final DailyConsumptionService dailyConsumptionService;
}
