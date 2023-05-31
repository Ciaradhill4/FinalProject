package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigUpdateService {

  List<Style> fetchStyle(String styleId);
  
  Optional<Style> updateStyles(String newStyleId, BigDecimal basePrice);


}
