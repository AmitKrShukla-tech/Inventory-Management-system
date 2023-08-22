package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDto;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PurchaseService {

    PurchaseDto addNewItem(long id, PurchaseDto purchaseDto);

    List<PurchaseDto> getAllPurchase();

    PurchaseDto getPurchaseById(long id);

    void deletePurchaseById(long id);

    PurchaseDto updatePurchaseById(PurchaseDto purchaseDto, long id);

}
