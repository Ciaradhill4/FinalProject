package com.promineotech.finalproject.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.dao.WigSalesDao;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultWigSalesService implements WigSalesService {
  
  @Autowired
  private WigSalesDao wigSalesDao;
  
 @Transactional(readOnly = true)
  @Override
  public List<Style> fetchStyles(WigStyle style) {
    log.info("The fetchStyles method was called with style={}", style);
    
    List<Style> styles = wigSalesDao.fetchStyles(style);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", style);
      
      throw new NoSuchElementException(msg);
    } 
    return styles;
  }
}
 
