package com.sparrowSoftech.InventoryManagementSystem.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ItemCodeGenerator {

    private static final String PREFIX="ItemCode-";
    private static final int INITIAL_SEQUENCE = 1000;

    private AtomicInteger sequence = new AtomicInteger(INITIAL_SEQUENCE);

    public String itemCodeGenerator(){
        int nextSequence = sequence.incrementAndGet();
        return PREFIX + nextSequence;
    }
}
