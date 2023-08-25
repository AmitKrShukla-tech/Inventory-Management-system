package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.Item;
import com.sparrowSoftech.InventoryManagementSystem.entities.PurchaseDetails;
import com.sparrowSoftech.InventoryManagementSystem.entities.Sale;
import com.sparrowSoftech.InventoryManagementSystem.entities.SaleDetails;
import com.sparrowSoftech.InventoryManagementSystem.exception.QuantityNotFoundException;
import com.sparrowSoftech.InventoryManagementSystem.exception.ResourceNotFoundExceptions;
import com.sparrowSoftech.InventoryManagementSystem.mapper.SaleDetailsMapper;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDetailsDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.ItemRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.PurchaseDetailsRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.SaleDetailsRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.SaleRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.SaleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleDetailsServiceImpl extends SaleDetailsMapper implements SaleDetailsService {

    @Autowired
    private SaleDetailsRepository saleDetailsRepo;

    @Autowired
    private ItemRepository itemRepo;
    @Autowired
    private SaleRepository saleRepo;
    @Autowired
    private PurchaseDetailsRepository purchaseDetailsRepo;

    @Override
    public SaleDetailsDto addNewSaleDetail(long sale_id, long item_id, SaleDetailsDto saleDetailsDto) {
        SaleDetails saleDetailsEntity = maptoSaleDetailsEntity(saleDetailsDto);
        Item item = itemRepo.findById(item_id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Item", "id", item_id));
        Sale sale = saleRepo.findById(sale_id).orElseThrow(() -> new
                ResourceNotFoundExceptions("sale", "id", sale_id));
        String customerName = sale.getCustomerName();
        PurchaseDetails purchaseDetails = purchaseDetailsRepo.findById(item_id).orElseThrow(() -> new
                ResourceNotFoundExceptions("itemId", "id", item_id));

        double itemQuantity = purchaseDetails.getQuantity();
        double saleQuantity = saleDetailsEntity.getQuantity();

        if (saleQuantity<itemQuantity){

            saleDetailsEntity.setPrice(item.getPrice());
            saleDetailsEntity.setItem(item);
            saleDetailsEntity.setSale(sale);
            saleDetailsEntity.setAmount(BigDecimal.valueOf(saleDetailsEntity.getPrice() * saleDetailsEntity.getQuantity() + saleDetailsEntity.getQuantity() * 1000));
            saleDetailsEntity.setDateTime(LocalDateTime.now());
            Optional<SaleDetails> byId = saleDetailsRepo.findById(sale_id);
            saleDetailsEntity.setPrice(saleDetailsEntity.getPrice());
            SaleDetails saleDetails = saleDetailsRepo.save(saleDetailsEntity);
            SaleDetailsDto newSaleDetails = mapToSaleDetailsDto(saleDetails);
            return newSaleDetails;
        }
        else{
            throw new QuantityNotFoundException("Not sufficient Quantity Please Try After Sometime" +
                    "  Thanks For Shoping With Us              !!");
        }
    }
//            double itemQuantity = itemDetailsByItemId.getQuantity();
//            double saleQuantity = saleDetailsEntity.getQuantity();
//            saleDetailsEntity.setPrice(itemDetailsByItemId.getPrice());
//            saleDetailsEntity.setDateTime(itemDetailsByItemId.getDateTime());
//            System.out.println(byItemId.getId());
//            double stockQuantity = byItemId.getQuantity();
//            double saleQuantity = saleDetailsEntity.getQuantity();
//            if (saleQuantity >= stockQuantity) {
//            saleDetailsEntity.getDateTime();
//            saleDetailsEntity.setItem(item);
//            saleDetailsEntity.setSale(sale);



    @Override
    public List<SaleDetailsDto> getAllSaleDetails() {
        List<SaleDetails> saleDetailsList = saleDetailsRepo.findAll();
        return saleDetailsList.stream().map(saleDetails -> mapToSaleDetailsDto(saleDetails)).collect(Collectors.toList());
    }

    @Override
    public SaleDetailsDto getSaleDetailsById(long id) {
        SaleDetails saleDetails = saleDetailsRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("SaleDetails", "id", id));
        SaleDetailsDto saleDetailsDto = mapToSaleDetailsDto(saleDetails);
        return saleDetailsDto;
    }

    @Override
    public void deleteSaleDetailById(long id) {
        SaleDetails saleDetails = saleDetailsRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Sale Details", "id", id));

        saleDetailsRepo.delete(saleDetails);
    }

    @Override
    public SaleDetailsDto updateSaleDetailsRecordById(long id, SaleDetailsDto saleDetailsDto) {
        SaleDetails saleDetails = saleDetailsRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Sale Details", "id", id));

        saleDetails.setQuantity(saleDetailsDto.getQuantity());
        saleDetails.setPrice(saleDetails.getPrice());
        saleDetails.setAmount(saleDetailsDto.getAmount());
        saleDetails.setStatus(saleDetailsDto.getStatus());

        SaleDetails save = saleDetailsRepo.save(saleDetails);
        SaleDetailsDto updatedSaleDetails = mapToSaleDetailsDto(save);
        return updatedSaleDetails;
    }


}
