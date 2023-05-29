package com.promineotech.finalproject.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.finalproject.dao.WigDeleteDao;
import com.promineotech.finalproject.entity.Style;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultWigDeleteService implements WigDeleteService {
  
  @Autowired
  private WigDeleteDao wigDeleteDao;

  
@Override
public Optional<Style> deleteStyles(Style styleId) {
log.info("The deleteStyles method was called with style={}", styleId);
  
  Optional<Style> styles = wigDeleteDao.deleteStyles(styleId);
  
  if(styles.isEmpty()) {
    String msg = String.format("No wigs found with style=%s", styleId);
    
    throw new NoSuchElementException(msg);
  } 
  return deleteStyles(styleId);
}

}
