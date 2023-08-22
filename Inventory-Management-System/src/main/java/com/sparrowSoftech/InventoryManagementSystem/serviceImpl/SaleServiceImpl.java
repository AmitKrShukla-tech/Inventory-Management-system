package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.Sale;
import com.sparrowSoftech.InventoryManagementSystem.exception.ResourceNotFoundExceptions;
import com.sparrowSoftech.InventoryManagementSystem.mapper.SaleMapper;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.SaleRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.SaleService;
import com.sparrowSoftech.InventoryManagementSystem.util.SaleInvoiceNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl extends SaleMapper implements SaleService {

    @Autowired
    private SaleRepository saleRepo;

    @Autowired
    private SaleInvoiceNumberGenerator saleInvoiceNumberGenerator;


    @Override
    public SaleDto addNewSale(SaleDto saleDto) {
        Sale sale = mapToSaleEntity(saleDto);
        String invoiceNumber = saleInvoiceNumberGenerator.invoiceNumberGenerator();
        sale.setInvoiceNo(invoiceNumber);
        Sale newSale = saleRepo.save(sale);
        return mapToSaleDto(newSale);
    }


    ;
    @Override
    public List<SaleDto> getallSaleDetails() {
        List<Sale> saleList = saleRepo.findAll();
        List<SaleDto> listOfSales = saleList.stream().map(sale -> mapToSaleDto(sale)).collect(Collectors.toList());
        return listOfSales;
    }

    @Override
    public SaleDto getSaleInfoById(long id) {
        Sale getsSale = saleRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Sale information", "id", id));
        return mapToSaleDto(getsSale);
    }

    @Override
    public void  deleteSaleById(long id) {
        Sale deleteSale = saleRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("sale information", "id", id));

        saleRepo.delete(deleteSale);
    }

    @Override
    public SaleDto updateRecordById(SaleDto saleDto, long id) {

        Sale updateSale = saleRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundExceptions("sale information", "id", id));

        updateSale.setCustomerName(saleDto.getCustomerName());
        updateSale.setInvoiceNo(saleDto.getInvoiceNo());
        updateSale.setMobileNumber(saleDto.getMobileNumber());
        updateSale.setInvoiceDate(saleDto.getInvoiceDate());
        updateSale.setTotalAmount(saleDto.getTotalAmount());
        updateSale.setDateTime(saleDto.getDateTime());
        updateSale.setStatus(saleDto.getStatus());

        Sale updatedsale = saleRepo.save(updateSale);

        return mapToSaleDto(updatedsale);
    }
}
