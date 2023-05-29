package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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

@Override
public Optional<Style> createStyles(WigStyle style, BigDecimal basePrice) {
  log.info("The createStyles method was called with style={}, basePrice={}", style, basePrice);
  
  Optional<Style> styles = wigSalesDao.createStyles(style, basePrice);
  
  if(styles.isEmpty()) {
    String msg = String.format("No wigs found with style=%s", style);
    
    throw new NoSuchElementException(msg);
  } 
  return createStyles(style, basePrice);
  
}

//@Override
//public Optional<Style> updateStyles(Style newStyleId, BigDecimal basePrice) {
//log.info("The updateStyles method was called with style={}, basePrice={}", newStyleId, basePrice);
//  
//  Optional<Style> styles = wigSalesDao.updateStyles(newStyleId, basePrice);
//  
//  if(styles.isEmpty()) {
//    String msg = String.format("No wigs found with style=%s", newStyleId, basePrice);
//    
//    throw new NoSuchElementException(msg);
//  } 
//  return updateStyles(newStyleId, basePrice);
//}
//
//@Override
//public Optional<Style> deleteStyles(Style styleId) {
//log.info("The deleteStyles method was called with style={}", styleId);
//  
//  Optional<Style> styles = wigSalesDao.createStyles(styleId);
//  
//  if(styles.isEmpty()) {
//    String msg = String.format("No wigs found with style=%s", styleId);
//    
//    throw new NoSuchElementException(msg);
//  } 
//  return createStyles(styleId, basePrice);
//}

}
 
