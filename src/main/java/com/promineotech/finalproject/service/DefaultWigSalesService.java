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

@Override
public Optional<Style> updateStyles(WigStyle styleId, BigDecimal basePrice, WigStyle newStyle) {
log.info("The updateStyles method was called with style={}, basePrice={}", styleId, basePrice);
  
  Optional<Style> styles = wigSalesDao.updateStyles(styleId, basePrice, newStyle);
  
  if(styles.isEmpty()) {
    String msg = String.format("No wigs found with style=%s", newStyle, basePrice);
    
    throw new NoSuchElementException(msg);
  } 
  return updateStyles(styleId, basePrice, newStyle);
}

@Override
public Optional<Style> deleteStyles(WigStyle styleId, BigDecimal basePrice) {
log.info("The deleteStyles method was called with style={}, basePrice={}", styleId, basePrice);
  
  Optional<Style> styles = wigSalesDao.createStyles(styleId, basePrice);
  
  if(styles.isEmpty()) {
    String msg = String.format("No wigs found with style=%s", styleId);
    
    throw new NoSuchElementException(msg);
  } 
  return createStyles(styleId, basePrice);
}
}
 
