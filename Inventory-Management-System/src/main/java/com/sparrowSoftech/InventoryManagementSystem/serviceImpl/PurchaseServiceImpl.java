package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.Purchase;
import com.sparrowSoftech.InventoryManagementSystem.entities.Supplier;
import com.sparrowSoftech.InventoryManagementSystem.exception.ResourceNotFoundExceptions;
import com.sparrowSoftech.InventoryManagementSystem.mapper.PurchaseMapper;
import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.PurchaseRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.SupplierRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.PurchaseService;
import com.sparrowSoftech.InventoryManagementSystem.util.PurchaseInvoiceNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl extends PurchaseMapper implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepo;

    @Autowired
    private SupplierRepository supplierRepo;

    @Autowired
    private PurchaseInvoiceNumberGenerator purchaseInvoiceNumberGenerator;

    @Override
    public PurchaseDto addNewItem(long id,PurchaseDto purchaseDto) {
        Purchase purchase = mapToPurchaseEntity(purchaseDto);
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Supplier", "id", id));
        purchase.setSupplier(supplier);
        String invoiceNumber = purchaseInvoiceNumberGenerator.invoiceNumberGenerator();
        purchase.setInvoiceNo(invoiceNumber);

        Purchase purchaseItem = purchaseRepo.save(purchase);
        PurchaseDto newPurchaseItem = mapToPurchaseDto(purchaseItem);
        return newPurchaseItem;
    }

    @Override
    public List<PurchaseDto> getAllPurchase() {

        List<Purchase> purchaseList = purchaseRepo.findAll();
        return purchaseList.stream().map(allPurchase ->mapToPurchaseDto(allPurchase)).collect(Collectors.toList());
    }



    @Override
    public PurchaseDto getPurchaseById(long id) {
        Purchase purchase = purchaseRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Purchase", "id", id));
        PurchaseDto dto = mapToPurchaseDto(purchase);
        return dto;
    }

    @Override
    public void deletePurchaseById(long id) {
        Purchase purchase = purchaseRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Purchase", "id", id));
        purchaseRepo.delete(purchase);
    }

    @Override
    public PurchaseDto updatePurchaseById(PurchaseDto purchaseDto, long id) {
        Purchase purchaseEntity = mapToPurchaseEntity(purchaseDto);
        Purchase purchase = purchaseRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Purchases", "id", id));

        purchase.setInvoiceNo(purchaseEntity.getInvoiceNo());
        purchase.setInvoiceDate(purchaseEntity.getInvoiceDate());
        purchase.setTotalAmount(purchaseEntity.getTotalAmount());
        purchase.setStatus(purchaseEntity.getStatus());
        purchase.setDateTime(purchaseEntity.getDateTime());

        Purchase updatePurchase = purchaseRepo.save(purchase);

        PurchaseDto updatedPurchase = mapToPurchaseDto(updatePurchase);
        return updatedPurchase;
    }
}
