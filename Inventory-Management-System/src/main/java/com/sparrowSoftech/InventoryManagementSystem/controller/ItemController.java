package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.payload.ItemDto;
import com.sparrowSoftech.InventoryManagementSystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;


    //api=== http://localhost:8080/api/item/add
    @PostMapping("/add")
    public ResponseEntity<ItemDto> addNewItem(@RequestBody ItemDto itemDto){
        ItemDto newItem = itemService.addItem(itemDto);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }


    //api=== http://localhost:8080/api/item/getall
    @GetMapping("/getall")
    public ResponseEntity<List<ItemDto>> getAllItem(){
        List<ItemDto> item = itemService.getallItem();
        return new ResponseEntity<>(item,HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/item/get/id
    @GetMapping("/get/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") long id){
        ItemDto itemById = itemService.getItemById(id);
        return new ResponseEntity<>(itemById,HttpStatus.FOUND);
    }


    //api=== http://localhost:8080/api/item/updateItem/id
    @PutMapping("/updateItem/{id}")
    public ResponseEntity<ItemDto> updateItemById(@RequestBody ItemDto itemDto, @PathVariable("id") long id){
        ItemDto updateItem = itemService.updateItemById(itemDto, id);
        return new ResponseEntity<>(updateItem,HttpStatus.ACCEPTED);
    }


    //api=== http://localhost:8080/api/item/deleteItem/id
    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable("id") long id){
        itemService.deleteItemById(id);

        return new ResponseEntity<>("Item Remove Successfully", HttpStatus.OK);
    }
}
