package com.promineotech.finalproject.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.dao.WigSalesDao;
import com.promineotech.finalproject.entity.Styles;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultWigSalesService implements WigSalesService {
  
  @Autowired
  private WigSalesDao wigSalesDao;
  
 @Transactional(readOnly = true)
  @Override
  public List<Styles> fetchStyles(Long stylePK) {
    log.info("The fetchStyles method was called with style={}", stylePK);
    
    List<Styles> styles = wigSalesDao.fetchStyles(stylePK);
    
    if(styles.isEmpty()) {
      String msg = String.format("No wigs found with style=%s", stylePK);
      
      throw new NoSuchElementException(msg);
    } 
    return styles;
  }
}

//@Override
//public Optional<Styles> createStyles(String style, BigDecimal basePrice) {
//  log.info("The createStyles method was called with style={}, basePrice={}", style, basePrice);
//  
//  Optional<Styles> styles = wigSalesDao.createStyles(style, basePrice);
//  
//  if(styles.isEmpty()) {
//    String msg = String.format("No wigs found with style=%s", style);
//    
//    throw new NoSuchElementException(msg);
//  } 
//  return createStyles(style, basePrice);
//  
//}
//
//@Override
//public Optional<Styles> updateStyles(String newStyleId, BigDecimal basePrice) {
//log.info("The updateStyles method was called with style={}, basePrice={}", newStyleId, basePrice);
//  
//  Optional<Styles> styles = wigSalesDao.updateStyles(newStyleId, basePrice);
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

//}
 
