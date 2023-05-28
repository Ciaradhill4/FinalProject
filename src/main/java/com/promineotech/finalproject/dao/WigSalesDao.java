package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;

public interface WigSalesDao {

  /**
   * 
   * @param styles
   * @return
   */
  List<Style> fetchStyles(WigStyle styleId);

  Optional<Style> createStyles(WigStyle styleId, BigDecimal basePrice);

  Optional<Style> updateStyles(WigStyle styleId, BigDecimal basePrice, WigStyle newStyleId);

  Optional<Style> deleteStyles(WigStyle styleId, BigDecimal basePrice);

}
