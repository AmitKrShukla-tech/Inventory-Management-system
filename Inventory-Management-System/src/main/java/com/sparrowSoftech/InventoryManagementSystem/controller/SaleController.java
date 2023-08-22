package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDto;
import com.sparrowSoftech.InventoryManagementSystem.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;


    //api=== http://localhost:8080/api/sale/addNew
    @PostMapping("/addNew")
    public ResponseEntity<SaleDto> generateNewSale(@RequestBody SaleDto saleDto){
        SaleDto newSale = saleService.addNewSale(saleDto);
        return new ResponseEntity<>(newSale, HttpStatus.CREATED);
    }

    //api=== http://localhost:8080/api/sale/getallSaleInfo
    @GetMapping("/getallSaleInfo")
    public ResponseEntity<List<SaleDto>> GenerateAllSaleDetails(){
        List<SaleDto> saleList = saleService.getallSaleDetails();
        return new ResponseEntity<>(saleList,HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/sale/get/id
    @GetMapping("/get/{id}")
    public ResponseEntity<SaleDto> getSaleInfoById(@PathVariable("id") long id){
        SaleDto saleInfoById = saleService.getSaleInfoById(id);
        return new ResponseEntity<>(saleInfoById, HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/sale/delete/id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSaleById(@PathVariable("id") long id){
        saleService.deleteSaleById(id);
        return new ResponseEntity<>("Sale Information delete Successfully !!", HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/sale/updaterecord/id
    @PutMapping("/updaterecord/{id}")
    public ResponseEntity<SaleDto> updatedSaleRecordById(@RequestBody SaleDto saleDto, @PathVariable("id") long id){
        SaleDto updatedSaleRecord = saleService.updateRecordById(saleDto, id);
        return new ResponseEntity<>(updatedSaleRecord, HttpStatus.OK);
    }
}
