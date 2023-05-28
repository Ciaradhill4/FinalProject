package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;

public interface WigSalesService {

  List<Style> fetchStyles(WigStyle style);

    Optional<Style> createStyles(WigStyle styleId, BigDecimal basePrice);
    
    Optional<Style> updateStyles(WigStyle styleId, BigDecimal basePrice, WigStyle newStyleId);
   
    Optional<Style> deleteStyles(WigStyle styleId, BigDecimal basePrice);
}
