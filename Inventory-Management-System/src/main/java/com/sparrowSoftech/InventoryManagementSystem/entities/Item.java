package com.sparrowSoftech.InventoryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_mstr")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(nullable = false, unique = true)
    private String itemName;
    @Column(nullable = false,unique = true)
    private String itemCode;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private long brandId;
    private String status;
    @CurrentTimestamp
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseDetails> purchaseDetailsList;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetails> saleDetails;
}
