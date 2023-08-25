package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.Item;
import com.sparrowSoftech.InventoryManagementSystem.entities.Purchase;
import com.sparrowSoftech.InventoryManagementSystem.entities.PurchaseDetails;
import com.sparrowSoftech.InventoryManagementSystem.exception.ResourceNotFoundExceptions;
import com.sparrowSoftech.InventoryManagementSystem.mapper.PurchaseDetailsMapper;
import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDetailsDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.ItemRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.PurchaseDetailsRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.PurchaseRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.PurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseDetailsServiceImpl extends PurchaseDetailsMapper implements PurchaseDetailsService {

    @Autowired
    private PurchaseDetailsRepository purchaseDetailsRepo;

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private PurchaseRepository purchaseRepo;

    @Override
    public PurchaseDetailsDto addNewPurchasesDetail(long item_id, long purchase_id, PurchaseDetailsDto purchaseDetailsDto) {

        PurchaseDetails purchaseDetails = mapToPurchaseDetailsEntity(purchaseDetailsDto);
        Item item = itemRepo.findById(item_id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Item Details", "id", item_id));
        purchaseDetails.setPrice(item.getPrice());
        purchaseDetails.setItem(item);
        Purchase purchase = purchaseRepo.findById(purchase_id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Pruchase Details", "id", purchase_id));

//        purchase.setInvoiceNo(purchase.getInvoiceNo());
//        purchase.setInvoiceDate(purchase.getInvoiceDate());
//        purchase.setSupplier(purchase.getSupplier());
//        purchaseDetails.setPurchase(purchase);

        purchaseDetails.setAmount(BigDecimal.valueOf(purchaseDetails.getPrice() * purchaseDetails.getQuantity()));
        PurchaseDetails newPurchaseDetails = purchaseDetailsRepo.save(purchaseDetails);
        return mapToPurchaseDetailsDto(newPurchaseDetails);
    }

    @Override
    public List<PurchaseDetailsDto> getallPurchaseDetails() {
        List<PurchaseDetails> purchaseDetailsList = purchaseDetailsRepo.findAll();
        return purchaseDetailsList.stream().map(details -> mapToPurchaseDetailsDto(details)).collect(Collectors.toList());
    }

    @Override
    public PurchaseDetailsDto getPurchaseDetailById(long id) {
        PurchaseDetails purchaseDetails = purchaseDetailsRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Product Details", "id", id));
        return mapToPurchaseDetailsDto(purchaseDetails);
    }

    @Override
    public void deletePurchaseDetailById(long id) {
        PurchaseDetails purchaseDetails = purchaseDetailsRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Purchase Detail", "id", id));
        purchaseDetailsRepo.delete(purchaseDetails);
    }

    @Override
    public PurchaseDetailsDto updatePurchaseDetailRecordById(PurchaseDetailsDto purchaseDetailsDto, long id) {
        PurchaseDetails details = mapToPurchaseDetailsEntity(purchaseDetailsDto);
        PurchaseDetails purchaseDetails = purchaseDetailsRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Purchase detail", "id", id));

        double quantity = purchaseDetails.getQuantity();
        double quantity1 = details.getQuantity();
        BigDecimal amount = purchaseDetails.getAmount();
        BigDecimal amount1 = details.getAmount();
        purchaseDetails.setPrice(purchaseDetails.getPrice());
        purchaseDetails.setQuantity(quantity+quantity1);
        purchaseDetails.setAmount(purchaseDetails.getAmount());
        purchaseDetails.setDateTime(purchaseDetails.getDateTime());
        purchaseDetails.setStatus(purchaseDetails.getStatus());

        PurchaseDetails save = purchaseDetailsRepo.save(purchaseDetails);
        return mapToPurchaseDetailsDto(save);
    }

//    @Override
//    public void reduceQuantity(long purchaseId, long itemId, PurchaseDetailsDto purchaseDetailsDto) {
//
//        PurchaseDetails purchaseDetails = mapToPurchaseDetailsEntity(purchaseDetailsDto);
//
//        Purchase purchase = purchaseRepo.findById(purchaseId).orElseThrow(() -> new
//                ResourceNotFoundExceptions("Purchase Details", "id", purchaseId));
//
//        Item item = itemRepo.findById(itemId).orElseThrow(() -> new
//                ResourceNotFoundExceptions("Item Details", "id", itemId));
//
//        if (purchaseDetails.getQuantity() < purchaseDetailsDto.getQuantity()){
//            throw new ResourceNotFoundExceptions("Quntity","id",itemId);
//        }
//
//        purchaseDetails.setQuantity(purchaseDetails.getQuantity() - purchaseDetailsDto.getQuantity());
//
//        PurchaseDetails save = purchaseDetailsRepo.save(purchaseDetails);
//        mapToPurchaseDetailsDto(save);
//    }




}
