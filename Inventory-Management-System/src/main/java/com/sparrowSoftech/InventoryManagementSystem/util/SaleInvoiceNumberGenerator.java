package com.sparrowSoftech.InventoryManagementSystem.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SaleInvoiceNumberGenerator {

        private static final String PREFIX="INVOICE-SALE-";
        private static final int INITIAL_SEQUENCE = 100;

        private AtomicInteger sequence = new AtomicInteger(INITIAL_SEQUENCE);

        public String invoiceNumberGenerator(){
            int nextSequence = sequence.incrementAndGet();
            return PREFIX + nextSequence;
        }
}
