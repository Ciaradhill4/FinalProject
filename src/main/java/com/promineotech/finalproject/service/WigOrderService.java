package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import com.promineotech.finalproject.entity.Color;
import com.promineotech.finalproject.entity.Customer;
import com.promineotech.finalproject.entity.Length;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.Texture;

public interface WigOrderService {

  Orders createOrder(OrderRequest orderRequest);

  Orders saveOrder(Customer customer, Style style, Color color, Texture texture, Length length,
      BigDecimal price);

  Object fetchLength(String length);
  

}
