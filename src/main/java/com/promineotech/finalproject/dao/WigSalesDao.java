package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Styles;

public interface WigSalesDao {

  /**
   * 
   * @param styles
   * @return
   */
  List<Styles> fetchStyles(Long stylePK);

  Optional<Styles> createStyles(Long stylePK, String styleId, BigDecimal basePrice);

  Optional<Styles> updateStyles(String newStyleId, BigDecimal basePrice);

}
