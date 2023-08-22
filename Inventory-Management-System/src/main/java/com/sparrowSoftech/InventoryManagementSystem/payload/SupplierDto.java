package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Data
public class SupplierDto {

    private long id;
    @NotEmpty(message = "Supplier Name Required")
    private String supplierName;
    @NotEmpty(message = "Mobile No Required")
    @Size(min = 10, max = 10)
    @Pattern(regexp = "(^[6-9]{1}[0-9]{9})$", message = "Mobile number should be 10 digits and Start from 6 to 9")
    private String mobileNo;
    @NotEmpty(message = "put Address here !!")
    private String address;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @NotEmpty(message = "Status Required")
    private String status;
}
