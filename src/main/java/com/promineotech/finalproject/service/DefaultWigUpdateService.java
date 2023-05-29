package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.dao.WigUpdateDao;
import com.promineotech.finalproject.entity.Style;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultWigUpdateService implements WigUpdateService {
  
  @Autowired
  private WigUpdateDao wigUpdateDao;

  @Transactional(readOnly = true)
  @Override
  public Optional<Style> updateStyles(Style newStyleId, BigDecimal basePrice) {
  log.info("The updateStyles method was called with style={}, basePrice={}", newStyleId, basePrice);
    
    Optional<Style> styles = wigUpdateDao.updateStyles(newStyleId, basePrice);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", newStyleId, basePrice);
      
      throw new NoSuchElementException(msg);
    } 
    return updateStyles(newStyleId, basePrice);

  }
  
  

}
