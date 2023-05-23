package com.promineotech.finalproject.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {
  @LocalServerPort
  private int serverPort;
  
  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  
  public String getBaseUriForWigStyle() {
    return String.format("http://localhost:%d/wigstyle", serverPort);
  }
  
 
  public String getBaseUriForOrder() {
    return String.format("http://localhost:%d/orders", serverPort);
  }
}
