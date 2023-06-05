package com.promineotech.finalproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Styles;
import com.promineotech.finalproject.service.WigSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigSalesController implements WigSalesController {

  @Autowired
  private WigSalesService wigSalesService;
  
  @Override
  public List<Styles>fetchStyles(Long stylePK) {
    log.debug("style={}", stylePK);
    return wigSalesService.fetchStyles(stylePK);
  }
  
//  Optional<Styles> createStyles(String styleId, BigDecimal basePrice) {
//    log.info("The createStyles method was called with styleId={}, basePrice={}", styleId, basePrice);
//    
//    Optional<Styles> styles = wigSalesService.createStyles(styleId, basePrice);
//    
//    if(styles.isEmpty()) {
//      String msg = String.format("No wigs found with style=%s", styleId);
//      
//      throw new NoSuchElementException(msg);
//    } 
//    return createStyles(styleId, basePrice);
//  }
}
