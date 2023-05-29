package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigUpdateService {

  Optional<Style> updateStyles(Style newStyleId, BigDecimal basePrice);

}
