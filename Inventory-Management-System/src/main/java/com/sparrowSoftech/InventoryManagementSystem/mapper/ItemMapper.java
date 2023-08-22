package com.sparrowSoftech.InventoryManagementSystem.mapper;

import com.sparrowSoftech.InventoryManagementSystem.entities.Item;
import com.sparrowSoftech.InventoryManagementSystem.payload.ItemDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemMapper {

    @Autowired
    private ModelMapper modelMapper;

    //Convert Entity to Dto
    public ItemDto mapToItemDto(Item item){
        ItemDto itemDto = modelMapper.map(item, ItemDto.class);
        return itemDto;
    }

    // Convert DTO to Entity
    public Item mapToItemEntity(ItemDto itemDto){
        Item itemEntity = modelMapper.map(itemDto, Item.class);
        return itemEntity;
    }
}
