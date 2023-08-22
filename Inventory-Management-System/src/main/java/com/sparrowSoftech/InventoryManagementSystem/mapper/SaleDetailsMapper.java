package com.sparrowSoftech.InventoryManagementSystem.mapper;

import com.sparrowSoftech.InventoryManagementSystem.controller.SaleDetailsController;
import com.sparrowSoftech.InventoryManagementSystem.entities.SaleDetails;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDetailsDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SaleDetailsMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SaleDetailsDto mapToSaleDetailsDto(SaleDetails saleDetails){
        SaleDetailsDto saleDetailsDto = modelMapper.map(saleDetails, SaleDetailsDto.class);
        return saleDetailsDto;
    }

    public SaleDetails maptoSaleDetailsEntity(SaleDetailsDto saleDetailsDto){
        SaleDetails saleDetailsEntity = modelMapper.map(saleDetailsDto, SaleDetails.class);
        return saleDetailsEntity;
    }
}
