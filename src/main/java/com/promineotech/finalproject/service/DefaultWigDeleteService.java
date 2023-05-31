package com.promineotech.finalproject.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.dao.WigDeleteDao;
import com.promineotech.finalproject.entity.Style;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultWigDeleteService implements WigDeleteService {
  
  @Autowired
  private WigDeleteDao wigDeleteDao;

  
  @Transactional(readOnly = true)
  @Override
  public List<Style> fetchStyle(String styleId){
    log.info("The fetchStyle method was called with style_id={}", styleId);
    
    return wigDeleteDao.fetchStyle(styleId);
  }
  
@Override
public Optional<Style> deleteStyles(String styleId) {
log.info("The deleteStyles method was called with style={}", styleId);
  
  Optional<Style> styles = wigDeleteDao.deleteStyles(styleId);
  
  if(styles.isEmpty()) {
    String msg = String.format("No wigs found with style=%s", styleId);
    
    throw new NoSuchElementException(msg);
  } 
  return deleteStyles(styleId);
}

}
