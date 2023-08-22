package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDetailsDto;

import java.util.List;

public interface PurchaseDetailsService {

    PurchaseDetailsDto addNewPurchasesDetail(long item_id, long purchase_id ,PurchaseDetailsDto purchaseDetailsDto);

    List<PurchaseDetailsDto> getallPurchaseDetails();

    PurchaseDetailsDto getPurchaseDetailById(long id);

    void deletePurchaseDetailById(long id);

    PurchaseDetailsDto updatePurchaseDetailRecordById(PurchaseDetailsDto purchaseDetailsDto,long id);

    void reduceQuantity(long purchaseId, long itemId, PurchaseDetailsDto purchaseDetailsDto);
}
