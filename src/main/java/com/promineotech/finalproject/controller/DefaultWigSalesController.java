package com.promineotech.finalproject.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;
import com.promineotech.finalproject.service.WigSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigSalesController implements WigSalesController {

  @Autowired
  private WigSalesService wigSalesService;
  
  @Override
  public List<Style>fetchStyles(WigStyle styleId) {
    log.debug("style={}", styleId);
    return wigSalesService.fetchStyles(styleId);
  }
  
  Optional<Style> createStyles(WigStyle styleId, BigDecimal basePrice) {
    log.info("The createStyles method was called with style={}, basePrice={}", styleId, basePrice);
    
    Optional<Style> styles = wigSalesService.createStyles(styleId, basePrice);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", styleId);
      
      throw new NoSuchElementException(msg);
    } 
    return createStyles(styleId, basePrice);
  }
  
//  Optional<Style> updateStyles(Style newStyleId, BigDecimal basePrice) {
//    log.info("The updateStyles method was called with style={}, basePrice={}", newStyleId, basePrice);
//    
//    Optional<Style> styles = wigSalesService.updateStyles(newStyleId, basePrice);
//    
//    if(styles.isEmpty()) {
//      String msg = String.format("No wigs found with style=%s", newStyleId, basePrice);
//      
//      throw new NoSuchElementException(msg);
//    } 
//    return updateStyles(newStyleId, basePrice);
//  }
 
//  Optional<Style> deleteStyles(Style styleId, BigDecimal basePrice) {
//    log.info("The deleteStyles method was called with style={}, basePrice={}", styleId, basePrice);
//    
//    Optional<Style> styles = wigSalesService.deleteStyles(styleId, basePrice);
//    
//    if(styles.isEmpty()) {
//      String msg = String.format("No wigs found with style=%s", styleId);
//      
//      throw new NoSuchElementException(msg);
//    } 
//    return deleteStyles(styleId, basePrice);
//  }
}
