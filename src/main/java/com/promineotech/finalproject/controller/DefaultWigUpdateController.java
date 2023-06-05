package com.promineotech.finalproject.controller;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Styles;
import com.promineotech.finalproject.service.WigUpdateService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigUpdateController implements WigUpdateController {
  
  @Autowired
  private WigUpdateService wigUpdateService;

  @Override
  public Optional<Styles> updateStyles(Long stylePK, String styleId, BigDecimal basePrice) {
    log.info("The updateStyles method was called with stylePK ={}", 
        stylePK);
    
    Optional<Styles> styles = wigUpdateService.updateStyles(stylePK, styleId, basePrice);
    
    if(styles.isEmpty()) {
      String msg = String.format("Wig can not be created with styles=%s", styles);
      
      throw new NoSuchElementException(msg);
    } 
    return styles;
  }
}
