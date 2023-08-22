package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Data
public class ItemDto {

    private long id;
    @NotEmpty(message = "Item Name must be required")
    private String itemName;
    @NotEmpty(message = "Item Code must be required")
    private String itemCode;
    @NotEmpty(message = "Enter the item price")
    private float price;
    @NotEmpty(message = "Brand Id must be required")
    private long brandId;
    @NotEmpty
    private String status;
    @CurrentTimestamp
    private LocalDateTime dateTime;

}
