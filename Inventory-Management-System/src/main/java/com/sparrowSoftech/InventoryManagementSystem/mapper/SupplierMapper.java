package com.sparrowSoftech.InventoryManagementSystem.mapper;

import com.sparrowSoftech.InventoryManagementSystem.entities.Supplier;
import com.sparrowSoftech.InventoryManagementSystem.payload.SupplierDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierMapper {

    @Autowired
    private ModelMapper modelMapper;


    //Covert Entity into Dto
    public SupplierDto mapToSupplierDto(Supplier supplier){
        SupplierDto supplierDto = modelMapper.map(supplier, SupplierDto.class);
        return supplierDto;
    }


    // Convert DTO to Entity
    public Supplier mapToSupplierEntity(SupplierDto supplierDto){
        Supplier supplierEntity = modelMapper.map(supplierDto, Supplier.class);
        return supplierEntity;
    }
}
