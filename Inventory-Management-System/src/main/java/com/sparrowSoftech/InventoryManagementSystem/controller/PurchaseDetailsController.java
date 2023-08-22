package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.payload.PurchaseDetailsDto;
import com.sparrowSoftech.InventoryManagementSystem.service.PurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/purchasedetails")
public class PurchaseDetailsController {


    @Autowired
    private PurchaseDetailsService purchaseDetailsService;


    //api=== http://localhost:8080/api/purchasedetails/item_id/purchase_id/addNew
    @PostMapping("/{item_id}/{purchase_id}/addNew")
    public ResponseEntity<PurchaseDetailsDto> addNewPurchaseDetails(@PathVariable("item_id") long item_id,
                                                                @PathVariable("purchase_id") long purchase_id,
                                                              @RequestBody PurchaseDetailsDto purchaseDetailsDto){

        PurchaseDetailsDto newPurchasesDetails = purchaseDetailsService.addNewPurchasesDetail(item_id,
                                                                          purchase_id, purchaseDetailsDto);
        return new ResponseEntity<>(newPurchasesDetails, HttpStatus.CREATED);
    }


    //api=== http://localhost:8080/api/purchasedetails/getall
    @GetMapping("/getall")
    public ResponseEntity<List<PurchaseDetailsDto>> getAllPurchasesDetails(){
        List<PurchaseDetailsDto> purchaseDetails = purchaseDetailsService.getallPurchaseDetails();
        return new ResponseEntity<>(purchaseDetails, HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/purchasedetails/get/id
    @GetMapping("/get/{id}")
    public ResponseEntity<PurchaseDetailsDto> getPurchaseDetailById(@PathVariable("id") long id){
        PurchaseDetailsDto purchaseDetailById = purchaseDetailsService.getPurchaseDetailById(id);
        return new ResponseEntity<>(purchaseDetailById, HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/purchasedetails/delete/id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePurchaseDetailsById(@PathVariable("id") long id){
        purchaseDetailsService.deletePurchaseDetailById(id);
        return new ResponseEntity<>("Purchase Details delete Successfully!!", HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/purchasedetails/updateRecord/id
    @PutMapping("updateRecord/{id}")
    public ResponseEntity<PurchaseDetailsDto> updatePurchaseDetailsRecordById
    (@RequestBody PurchaseDetailsDto purchaseDetailsDto, @PathVariable("id") long id){

        PurchaseDetailsDto updatePurchaseRecord = purchaseDetailsService.updatePurchaseDetailRecordById
                (purchaseDetailsDto, id);
        return new ResponseEntity<>(updatePurchaseRecord,HttpStatus.CREATED);
    }

    //api=== http://localhost:8080/api/purchasedetails/purchase_id/item_id/quantity
//    @PutMapping("/{purchase_id}/{item_id}/quantity")
//    public ResponseEntity<Void> reduceQuantity(@PathVariable("purchase_id") long purchase_id,
//                                               @PathVariable("item_id") long item_id,
//                                               @RequestBody PurchaseDetailsDto purchaseDetailsDto){
//
//
//        purchaseDetailsService.reduceQuantity(purchase_id,item_id,purchaseDetailsDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//
//    }
}
