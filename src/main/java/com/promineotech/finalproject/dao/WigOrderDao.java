package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Color;
import com.promineotech.finalproject.entity.Customer;
import com.promineotech.finalproject.entity.Length;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.Texture;
import com.promineotech.finalproject.entity.WigColor;
import com.promineotech.finalproject.entity.WigStyle;


public interface WigOrderDao {
/**
 * 
 * @param customerId
 * @return
 */
  
  Optional<Customer> fetchCustomer(String customerId);
  Optional<Style> fetchStyle(WigStyle styleId);
  Optional<Color> fetchColor(WigColor colorId);
  Optional<Texture> fetchTexture(String textureId);
  Optional<Length> fetchLength(String lengthId);
  
  Orders saveOrder(Customer customer, Style style, Color color, Texture texture, Length length,
      BigDecimal price);
  static List<Style> fetchUpdateStyles(WigStyle style) {
    // TODO Auto-generated method stub
    return null;
  }
  

}
