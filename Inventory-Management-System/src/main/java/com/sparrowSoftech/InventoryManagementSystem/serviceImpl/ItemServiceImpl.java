package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.Item;
import com.sparrowSoftech.InventoryManagementSystem.exception.ResourceNotFoundExceptions;
import com.sparrowSoftech.InventoryManagementSystem.mapper.ItemMapper;
import com.sparrowSoftech.InventoryManagementSystem.payload.ItemDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.ItemRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.ItemService;
import com.sparrowSoftech.InventoryManagementSystem.util.ItemCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl extends ItemMapper implements ItemService {

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private ItemCodeGenerator itemCodeGenerator;


    @Override
    public ItemDto addItem(ItemDto itemDto) {
        Item item = mapToItemEntity(itemDto);
        String codeGenerator = itemCodeGenerator.itemCodeGenerator();
        item.setItemCode(codeGenerator);
        Item itemSave = itemRepo.save(item);
        ItemDto newItem = mapToItemDto(itemSave);
        return newItem;
    }

    @Override
    public List<ItemDto> getallItem() {
        List<Item> allItem = itemRepo.findAll();
        return allItem.stream().map(item ->mapToItemDto(item)).collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(long id) {
        Item item = itemRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Item", "Id", id));
        return mapToItemDto(item);
    }

    @Override
    public ItemDto updateItemById(ItemDto itemDto, long id) {

        Item item = mapToItemEntity(itemDto);
        Item updatedItem = itemRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Item", "id", id));

        updatedItem.setItemName(item.getItemName());
        updatedItem.setItemCode(item.getItemCode());
        updatedItem.setPrice(item.getPrice());
        updatedItem.setBrandId(item.getBrandId());
        updatedItem.setStatus(item.getStatus());

        Item newUpdatedItem = itemRepo.save(updatedItem);
        return mapToItemDto(newUpdatedItem);
    }

    @Override
    public void deleteItemById(long id) {
        Item item = itemRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Item", "id", id));

        itemRepo.delete(item);
    }

}
