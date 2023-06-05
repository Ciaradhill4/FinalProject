package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.Optional;
import com.promineotech.finalproject.entity.Color;
import com.promineotech.finalproject.entity.Customer;
import com.promineotech.finalproject.entity.Lengths;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.entity.Styles;
import com.promineotech.finalproject.entity.Texture;


public interface WigOrderDao {
/**
 * 
 * @param customer
 * @return
 */
  
  Optional<Customer> fetchCustomer(String customerId);
  Optional<Styles> fetchStyle(String styleId);
  Optional<Color> fetchColor(String name);
  Optional<Texture> fetchTexture(String textureId);
  Optional<Lengths> fetchLength(int inches);
  Optional<BigDecimal> fetchPrice(BigDecimal price);
  
  Orders createOrder(OrderRequest orderRequest);
 
  Orders saveOrders(Customer customer, Styles style, Color name, Texture texture, 
      Lengths inches, BigDecimal price);
  
  
  
  
}
