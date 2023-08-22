package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.payload.SupplierDto;
import com.sparrowSoftech.InventoryManagementSystem.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    //api=== http://localhost:8080/api/supplier/addnewsupplier
    @PostMapping("/addnewsupplier")
    public ResponseEntity<SupplierDto> createSupplier(@Valid @RequestBody SupplierDto supplierDto){
        SupplierDto supplier = supplierService.createSupplier(supplierDto);
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }


    //api=== http://localhost:8080/api/supplier/allsupplier
    @GetMapping("/allsupplier")
    public List<SupplierDto> getAllSupplier(){
        return supplierService.getAllSupplier();
    }


    //api=== http://localhost:8080/api/supplier/id
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable("id") long id){
        SupplierDto supplierById = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplierById,HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/supplier/update/id
    @PutMapping("/update/{id}")
    public ResponseEntity<SupplierDto> updateSupplierById(@RequestBody SupplierDto supplierDto,@PathVariable("id") long id){
        SupplierDto updatedSupplier = supplierService.updateSupplierById(supplierDto,id);
        return new ResponseEntity<>(updatedSupplier,HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/supplier/delete/id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable("id") long id){
        supplierService.deleteSupplierById(id);
        return new ResponseEntity<>("Supplier deleted successfully.",HttpStatus.OK);
    }
}
