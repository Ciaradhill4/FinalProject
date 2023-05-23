package com.promineotech.finalproject.service;

import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;

public interface WigOrderService {

  Orders createOrder(OrderRequest orderRequest);

}
