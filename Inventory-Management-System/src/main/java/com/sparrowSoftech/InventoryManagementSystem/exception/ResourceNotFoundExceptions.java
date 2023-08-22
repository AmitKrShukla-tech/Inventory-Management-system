package com.sparrowSoftech.InventoryManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends RuntimeException{

    private String resourceName;
    private String filedName;
    private long filedValue;

    public ResourceNotFoundExceptions(String resourceName, String filedName, long filedValue) {

        // supplier not found with id : 1

        super(String.format("%s not found with %s : '%S'", resourceName,filedName,filedValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.filedValue = filedValue;
    }
}
