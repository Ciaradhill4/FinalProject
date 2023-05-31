package com.promineotech.finalproject.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.service.WigSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigSalesController implements WigSalesController {

  @Autowired
  private WigSalesService wigSalesService;
  
  @Override
  public List<Style>fetchStyles(String styleId) {
    log.debug("style={}", styleId);
    return wigSalesService.fetchStyles(styleId);
  }
  
  Optional<Style> createStyles(String style, BigDecimal basePrice) {
    log.info("The createStyles method was called with style={}, basePrice={}", style, basePrice);
    
    Optional<Style> styles = wigSalesService.createStyles(style, basePrice);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", style);
      
      throw new NoSuchElementException(msg);
    } 
    return createStyles(style, basePrice);
  }
}
