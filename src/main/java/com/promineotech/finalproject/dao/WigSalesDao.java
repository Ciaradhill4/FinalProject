package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigSalesDao {

  /**
   * 
   * @param styles
   * @return
   */
  List<Style> fetchStyles(String style);

  Optional<Style> createStyles(String style, BigDecimal basePrice);

  Optional<Style> updateStyles(String newStyleId, BigDecimal basePrice);

}
