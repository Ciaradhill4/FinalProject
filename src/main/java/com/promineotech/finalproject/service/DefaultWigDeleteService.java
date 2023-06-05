package com.promineotech.finalproject.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.finalproject.dao.WigDeleteDao;
import com.promineotech.finalproject.entity.Styles;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultWigDeleteService implements WigDeleteService {
  
  @Autowired
  private WigDeleteDao wigDeleteDao;
  
@Override
public Optional<Styles> deleteStyles(Long stylePK) {
log.info("The deleteStyles method was called with style={}", stylePK);
  
  Optional<Styles> styles = wigDeleteDao.deleteStyles(stylePK);
  
  if(styles.isEmpty()) {
    String msg = String.format("No wigs found with style=%s", stylePK);
    
    throw new NoSuchElementException(msg);
  } 
  return styles;
}

}
