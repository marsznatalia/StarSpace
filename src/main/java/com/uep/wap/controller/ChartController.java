package com.uep.wap.controller;

import com.uep.wap.dto.ChartDTO;
import com.uep.wap.model.Chart;
import com.uep.wap.service.ChartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ChartController {
    private final ChartService chartService;

    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping(path = "/charts")
    public Iterable<Chart> getAllCharts() {
        return chartService.getAllCharts();
    }

    @PostMapping(path = "/charts")
    public String addCharts(@RequestBody ChartDTO chartDTO) {
        chartService.addChart(chartDTO);
        return "Charts added!";
    }
}
