package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.Optional;
import com.promineotech.finalproject.entity.Styles;

public interface WigUpdateService {

 // List<Styles> fetchStyle(Long stylePK);

  Optional<Styles> updateStyles(Long stylePK, String styleId, BigDecimal basePrice);


}
