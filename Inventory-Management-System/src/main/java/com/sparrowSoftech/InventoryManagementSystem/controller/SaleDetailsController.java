package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDetailsDto;
import com.sparrowSoftech.InventoryManagementSystem.service.SaleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/saledetails")
public class SaleDetailsController {

    @Autowired
    private SaleDetailsService saleDetailsService;


    //api=== http:8080/api/saledetails/{sale_id}/{item_id}/add
    @PostMapping("{sale_id}/{item_id}/add")
    public ResponseEntity<SaleDetailsDto> addNewSaleDetails(@PathVariable("sale_id") long sale_id,
                                                            @PathVariable("item_id") long item_id,
                                                            @RequestBody SaleDetailsDto saleDetailsDto){

        SaleDetailsDto saleDetail = saleDetailsService.addNewSaleDetail(sale_id, item_id, saleDetailsDto);
        return new ResponseEntity<>(saleDetail, HttpStatus.CREATED);
    }


    //api=== http:8080/api/saledetails/getall
    @GetMapping("/getall")
    public ResponseEntity<List<SaleDetailsDto>> getAllSaleDetails(){
        List<SaleDetailsDto> allSaleDetails = saleDetailsService.getAllSaleDetails();
        return new ResponseEntity<>(allSaleDetails, HttpStatus.OK);
    }


    //api=== http:8080/api/saledetails/get/{id}
    @GetMapping("/get/{id}")
    public ResponseEntity<SaleDetailsDto> getSaleDetailById(@PathVariable("id") long id){
        SaleDetailsDto saleDetailsById = saleDetailsService.getSaleDetailsById(id);
        return new ResponseEntity<>(saleDetailsById, HttpStatus.OK);
    }


    //api=== http:8080/api/saledetails/delete/{id}
    @DeleteMapping("delete/id")
    public ResponseEntity<String> deleteSaleById(@PathVariable("id") long id){
        saleDetailsService.deleteSaleDetailById(id);
        return new ResponseEntity<>("Sale Details delete successfully !!", HttpStatus.OK);
    }


    //api=== http:8080/api/saledetails/update/{id}
    @PutMapping("update/{id}")
    public ResponseEntity<SaleDetailsDto> updateSaleDetailsById(@PathVariable("id") long id,
                                                                @RequestBody SaleDetailsDto saleDetailsDto){
        SaleDetailsDto updatedRecord = saleDetailsService.updateSaleDetailsRecordById(id, saleDetailsDto);
        return new ResponseEntity<>(updatedRecord, HttpStatus.CREATED);
    }
}
