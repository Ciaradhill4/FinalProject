package com.promineotech.finalproject.service;

import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;

public interface WigOrderService {

  Orders createOrder(OrderRequest orderRequest);

//  Orders saveOrders(Customer customer, Styles style, Color color, Texture texture, Lengths length,
//      BigDecimal price);

}
