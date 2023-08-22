package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.payload.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto createSupplier(SupplierDto supplierDto);

    List<SupplierDto> getAllSupplier();

    SupplierDto getSupplierById(long id);

    SupplierDto updateSupplierById(SupplierDto supplierDto, long id);

    void deleteSupplierById(long id);
}
