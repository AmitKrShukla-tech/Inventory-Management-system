package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.payload.ItemDto;

import java.util.List;

public interface ItemService {


    ItemDto addItem(ItemDto itemDto);

    List<ItemDto> getallItem();

    ItemDto getItemById(long id);

    ItemDto updateItemById(ItemDto itemDto, long id);

    void deleteItemById(long id);

}
