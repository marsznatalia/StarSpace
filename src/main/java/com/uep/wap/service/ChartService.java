package com.uep.wap.service;

import com.uep.wap.dto.ChartDTO;
import com.uep.wap.model.Chart;
import com.uep.wap.repository.ChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartService {

    @Autowired
    private ChartRepository chartRepository;

    public void addChart(ChartDTO chartDTO) {
        Chart chart = new Chart();
        chart.setName(chartDTO.getName());
        chart.setPoints(chartDTO.getPoints());
        chartRepository.save(chart);
        System.out.println("Charts added!");
    }

    public Iterable<Student> getAllCharts() {
        return chartRepository.findAll();
    }

}
