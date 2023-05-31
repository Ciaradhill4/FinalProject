package com.promineotech.finalproject.controller;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.service.WigUpdateService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigUpdateController implements WigUpdateController {
  
  @Autowired
  private WigUpdateService wigUpdateService;

  @Override
  public Optional<Style> updateStyles(String newStyleId, BigDecimal basePrice) {
    log.info("The updateStyles method was called with style={}, basePrice={}", newStyleId, basePrice);
    
    Optional<Style> styles = wigUpdateService.updateStyles(newStyleId, basePrice);
    
    if(styles.isEmpty()) {
      String msg = String.format("Wig can not be created with style=%s", newStyleId, basePrice);
      
      throw new NoSuchElementException(msg);
    } 
    return updateStyles(newStyleId, basePrice);
  }
}
