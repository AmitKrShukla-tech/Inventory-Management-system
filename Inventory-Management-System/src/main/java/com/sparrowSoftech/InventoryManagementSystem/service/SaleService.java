package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDto;

import java.util.List;

public interface SaleService {

    SaleDto addNewSale(SaleDto saleDto);

    List<SaleDto> getallSaleDetails();

    SaleDto getSaleInfoById(long id);

    void deleteSaleById(long id);

    SaleDto updateRecordById(SaleDto saleDto, long id);

}
