package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.dao.WigOrderDao;
import com.promineotech.finalproject.entity.Color;
import com.promineotech.finalproject.entity.Customer;
import com.promineotech.finalproject.entity.Length;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.entity.Style;
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
    Style style = getStyle(orderRequest);
    Color color = getColor(orderRequest);
    Texture texture = getTexture(orderRequest);
    Length length = getLength(orderRequest);
    
    BigDecimal price =
       style.getBasePrice().add(color.getPrice()).add(texture.getPrice())
       .add(length.getPrice());  
     
    log.debug("Order = {}", orderRequest);
    return wigOrderDao.saveOrder(customer, style, color, texture, length, price);
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Length getLength(OrderRequest orderRequest ) {
    return wigOrderDao.fetchLength(orderRequest.getLength())
        .orElseThrow(() -> new NoSuchElementException(
        "Tire with ID= " + orderRequest.getLength() + " was not found"));
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Texture getTexture(OrderRequest orderRequest) {
    return wigOrderDao.fetchTexture(orderRequest.getTexture())
        .orElseThrow(() -> new NoSuchElementException(
        "Engine with ID= " + orderRequest.getTexture() + " was not found"));
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Color getColor(OrderRequest orderRequest) {
    return wigOrderDao.fetchColor(orderRequest.getColor())
        .orElseThrow(() -> new NoSuchElementException(
        "Color with ID= " + orderRequest.getColor() + " was not found"));
  }
/**
 * 
 * @param orders
 * @return
 */
  protected Style getStyle(OrderRequest orderRequest) {
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
   
}