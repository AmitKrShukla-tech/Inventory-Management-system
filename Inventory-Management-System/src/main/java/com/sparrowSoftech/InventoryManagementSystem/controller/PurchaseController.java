package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDto;
import com.sparrowSoftech.InventoryManagementSystem.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;



    //api=== http://localhost:8080/api/purchase/supplier/{supplierID}/newItem
    @PostMapping("/supplier/{supplierid}/newItem")
    public ResponseEntity<PurchaseDto> purchaseNewItem(@Valid @PathVariable("supplierid") long id, @RequestBody PurchaseDto purchaseDto){
        PurchaseDto newItem = purchaseService.addNewItem(id, purchaseDto);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    //api=== http://localhost:8080/api/purchase/allPurchase/details
    @GetMapping("/allPurchase/details")
    public ResponseEntity<List<PurchaseDto>> getAllPurchase(){
        List<PurchaseDto> allPurchase = purchaseService.getAllPurchase();
        return new ResponseEntity<>(allPurchase, HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/purchase/id
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDto> getPurchaseById (@PathVariable("purchase_id") long id){
        PurchaseDto purchaseById = purchaseService.getPurchaseById(id);
        return new ResponseEntity<>(purchaseById, HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/purchase/delete/id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePurchaseById(@PathVariable("purchase_id") long id){
        purchaseService.deletePurchaseById(id);
        return new ResponseEntity<>("Purchase Details Deleted Successfully",HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/purchase/updated/id
    @PutMapping("/update/{id}")
    public ResponseEntity<PurchaseDto> updatedPurchaseById(@RequestBody PurchaseDto purchaseDto,
                                                           @PathVariable("purchase_id") long id){
        PurchaseDto updatedPurchase = purchaseService.updatePurchaseById(purchaseDto, id);
        return new ResponseEntity<>(updatedPurchase,HttpStatus.OK);
    }

}
