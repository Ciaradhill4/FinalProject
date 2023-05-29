package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigUpdateDao {

  Optional<Style> updateStyles(Style newStyleId, BigDecimal basePrice);

}
