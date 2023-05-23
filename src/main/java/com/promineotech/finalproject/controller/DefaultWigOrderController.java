package com.promineotech.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.service.WigOrderService;
import lombok.extern.slf4j.Slf4j;

@RestController 
@Service
@Slf4j
public class DefaultWigOrderController implements WigOrderController {
  
  @Autowired
  private WigOrderService wigOrderService;
  
  
  @Override
  public Orders createOrder(OrderRequest orderRequest) {
    log.debug("Order={}", orderRequest);
    return wigOrderService.createOrder(orderRequest);
  }

}
