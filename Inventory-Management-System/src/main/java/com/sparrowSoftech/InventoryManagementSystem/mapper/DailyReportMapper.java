package com.sparrowSoftech.InventoryManagementSystem.mapper;

import com.sparrowSoftech.InventoryManagementSystem.entities.DailyReport;
import com.sparrowSoftech.InventoryManagementSystem.payload.DailyReportDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DailyReportMapper {

    @Autowired
    private ModelMapper modelMapper;


    public DailyReportDto maptoDailyReportDto(DailyReport dailyReport){
        DailyReportDto dailyReportDto = modelMapper.map(dailyReport, DailyReportDto.class);
        return dailyReportDto;
    }

    public DailyReport mapToDailyReportEntity(DailyReportDto dailyReportDto){
        DailyReport mapToEntity = modelMapper.map(dailyReportDto, DailyReport.class);
        return mapToEntity;
    }

}
