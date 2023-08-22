package com.sparrowSoftech.InventoryManagementSystem.mapper;

import com.sparrowSoftech.InventoryManagementSystem.entities.PurchaseDetails;
import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDetailsDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseDetailsMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PurchaseDetailsDto mapToPurchaseDetailsDto(PurchaseDetails purchaseDetails){
        PurchaseDetailsDto purchaseDetailsDto = modelMapper.map(purchaseDetails, PurchaseDetailsDto.class);
        return purchaseDetailsDto;
    }

    // Convert DTO to Entity
    public PurchaseDetails mapToPurchaseDetailsEntity(PurchaseDetailsDto purchaseDetailsDto){
        PurchaseDetails purchaseDetailsEntity = modelMapper.map(purchaseDetailsDto, PurchaseDetails.class);
        return purchaseDetailsEntity;
    }
}
