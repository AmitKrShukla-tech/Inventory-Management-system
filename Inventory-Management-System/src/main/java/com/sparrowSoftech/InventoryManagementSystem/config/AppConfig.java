package com.sparrowSoftech.InventoryManagementSystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class AppConfig {

  @Bean
    public ModelMapper modelMapper(){
      return new ModelMapper();
  }

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }


}
