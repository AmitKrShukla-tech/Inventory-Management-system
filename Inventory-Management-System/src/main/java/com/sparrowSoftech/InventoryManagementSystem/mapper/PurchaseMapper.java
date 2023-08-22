package com.sparrowSoftech.InventoryManagementSystem.mapper;

import com.sparrowSoftech.InventoryManagementSystem.entities.Purchase;
import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PurchaseDto mapToPurchaseDto(Purchase purchase){
        PurchaseDto purchaseDto = modelMapper.map(purchase, PurchaseDto.class);
        return purchaseDto;
    }

    // Convert DTO to Entity
    public Purchase mapToPurchaseEntity(PurchaseDto purchaseDto){
        Purchase purchaseEntity = modelMapper.map(purchaseDto, Purchase.class);
        return purchaseEntity;
    }
}
