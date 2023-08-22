package com.sparrowSoftech.InventoryManagementSystem.mapper;

import com.sparrowSoftech.InventoryManagementSystem.entities.Sale;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SaleMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SaleDto mapToSaleDto(Sale sale){
        SaleDto saleDto = modelMapper.map(sale, SaleDto.class);
        return saleDto;
    }

    public Sale mapToSaleEntity(SaleDto saleDto){
        Sale saleEntity = modelMapper.map(saleDto, Sale.class);
        return saleEntity;
    }
}
