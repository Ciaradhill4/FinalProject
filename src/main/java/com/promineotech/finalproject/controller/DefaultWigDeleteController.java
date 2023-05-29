package com.promineotech.finalproject.controller;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.service.WigDeleteService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigDeleteController implements WigDeleteController {
  
  @Autowired
  private WigDeleteService wigDeleteService;

  @Override
  public Optional<Style> deleteStyles(Style styleId) {
    log.info("The deleteStyles method was called with style={}", styleId);
    
    Optional<Style> styles = wigDeleteService.deleteStyles(styleId);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", styleId);
      
      throw new NoSuchElementException(msg);
    } 
    return deleteStyles(styleId);
  }

}
