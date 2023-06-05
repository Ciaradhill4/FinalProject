package com.promineotech.finalproject.controller;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Styles;
import com.promineotech.finalproject.service.WigDeleteService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigDeleteController implements WigDeleteController {
  
  @Autowired
  private WigDeleteService wigDeleteService;

  @Override
  public Optional<Styles> deleteStyles(Long stylePK) {
    log.info("The deleteStyles method was called with style={}", stylePK);
    
    Optional<Styles> styles = wigDeleteService.deleteStyles(stylePK);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", stylePK);
      
      throw new NoSuchElementException(msg);
    } 
    return styles;
  }

}
