package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.dao.WigOrderDao;
import com.promineotech.finalproject.entity.Color;
import com.promineotech.finalproject.entity.Customer;
import com.promineotech.finalproject.entity.Lengths;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.entity.Styles;
import com.promineotech.finalproject.entity.Texture;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultWigOrderService implements WigOrderService {

  @Autowired
  private WigOrderDao wigOrderDao;
  
  @Transactional 
  @Override
  public Orders createOrder(OrderRequest orderRequest) {
    Customer customer = getCustomer(orderRequest); 
    Styles style = getStyle(orderRequest);
    Color name = getName(orderRequest);
    Texture texture = getTexture(orderRequest);
    Lengths inches = getInches(orderRequest);
    
    BigDecimal price = 
       style.getBasePrice().add(name.getPrice()).add(texture.getPrice())
       .add(inches.getPrice());  
     
    log.debug("Order = {}", orderRequest);
    return wigOrderDao.saveOrders(customer, style, name, texture, inches, price);
    
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Lengths getInches(OrderRequest orderRequest ) {
    return wigOrderDao.fetchLength(orderRequest.getInches())
        .orElseThrow(() -> new NoSuchElementException(
        "Length with inches= " + orderRequest.getInches() + " was not found"));
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Texture getTexture(OrderRequest orderRequest) {
    return wigOrderDao.fetchTexture(orderRequest.getTexture())
        .orElseThrow(() -> new NoSuchElementException(
        "Texture with ID= " + orderRequest.getTexture() + " was not found"));
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Color getName(OrderRequest orderRequest) {
    return wigOrderDao.fetchColor(orderRequest.getName())
        .orElseThrow(() -> new NoSuchElementException(
        "Color with name= " + orderRequest.getName() + " was not found"));
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Styles getStyle(OrderRequest orderRequest) {
    return wigOrderDao.fetchStyle(orderRequest.getStyle())
        .orElseThrow(() -> new NoSuchElementException(
        "Style with ID= " + orderRequest.getStyle() + " was not found"));
  }
/**
 * 
 * @param orderRequest
 * @return
 */
  protected Customer getCustomer(OrderRequest orderRequest) {
    return wigOrderDao.fetchCustomer(orderRequest.getCustomer())
        .orElseThrow(() -> new NoSuchElementException(
        "Customer with ID= " + orderRequest.getCustomer() + " was not found"));
  }
  
//@Override
//public Orders saveOrders(Customer customer, Styles style, Color name, Texture texture, 
  //Lengths inches, BigDecimal price) {
//  // TODO Auto-generated method stub
//  return saveOrders(customer, style, color, texture, length, price);
//}
   
}