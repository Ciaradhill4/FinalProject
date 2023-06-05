package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Styles;

public interface WigUpdateDao {

  List<Styles> fetchStyle(Long stylePK);
  
  Optional<Styles> updateStyles(Long stylePK, String styleId, BigDecimal basePrice);

}
