package com.sparrowSoftech.InventoryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "supplier_mstr")
@Table(name = "supplier_mstr")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name = "supplier_name", nullable = false,unique = true)
    private String supplierName;
    @Column(name = "mobile_no", nullable = false,unique = true)
    private String mobileNo;
    @Column(name = "address", nullable = false)
    private String address;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @Column(name = "status")
    private String status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchase = new ArrayList<>();

}
