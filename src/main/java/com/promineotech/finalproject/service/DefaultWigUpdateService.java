package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.finalproject.dao.WigUpdateDao;
import com.promineotech.finalproject.entity.Styles;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultWigUpdateService implements WigUpdateService {
  
  @Autowired
  private WigUpdateDao wigUpdateDao;

  @Override
  public Optional<Styles> updateStyles(Long stylePK, String styleId, BigDecimal basePrice) {
  log.info("The updateStyles method was called with style_pk={}", stylePK);
    
    Optional<Styles> styles = wigUpdateDao.updateStyles(stylePK, styleId, basePrice);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", stylePK);
      
      throw new NoSuchElementException(msg);
    } 
    return styles;

  }
}
