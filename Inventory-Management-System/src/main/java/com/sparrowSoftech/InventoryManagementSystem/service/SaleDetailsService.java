package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDetailsDto;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDto;

import java.util.List;

public interface SaleDetailsService {


    SaleDetailsDto addNewSaleDetail(long sale_id, long item_id, SaleDetailsDto saleDetailsDto);

    List<SaleDetailsDto> getAllSaleDetails();

    SaleDetailsDto getSaleDetailsById(long id);

    void deleteSaleDetailById(long id);

    SaleDetailsDto updateSaleDetailsRecordById(long id, SaleDetailsDto saleDetailsDto);
}
