package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.Supplier;
import com.sparrowSoftech.InventoryManagementSystem.exception.ResourceNotFoundExceptions;
import com.sparrowSoftech.InventoryManagementSystem.mapper.SupplierMapper;
import com.sparrowSoftech.InventoryManagementSystem.payload.SupplierDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.SupplierRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl extends SupplierMapper implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepo;

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = mapToSupplierEntity(supplierDto);
        Supplier saveSupplier = supplierRepo.save(supplier);
        SupplierDto saveNewSupplier = mapToSupplierDto(saveSupplier);
        return saveNewSupplier;
    }


    @Override
    public List<SupplierDto> getAllSupplier() {
        List<Supplier> supplierList = supplierRepo.findAll();
        return supplierList.stream().map(supplier -> mapToSupplierDto(supplier)).collect(Collectors.toList());
    }

    @Override
    public SupplierDto getSupplierById(long id) {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Supplier", "id", id));
        return mapToSupplierDto(supplier);
    }

    @Override
    public SupplierDto updateSupplierById(SupplierDto supplierDto,long id) {

        Supplier supplier = supplierRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundExceptions("Supplier", "id", id));

        supplier.setSupplierName(supplierDto.getSupplierName());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setMobileNo(supplierDto.getMobileNo());
        supplier.setStatus(supplierDto.getStatus());

        Supplier updateSupplier = supplierRepo.save(supplier);
        return mapToSupplierDto(updateSupplier);
    }

    @Override
    public void deleteSupplierById(long id) {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundExceptions("Supplier", "id", id));

        supplierRepo.delete(supplier);
    }
}
