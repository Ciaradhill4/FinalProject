package com.promineotech.finalproject.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigSalesService {

  List<Style> fetchStyles(String style);

    Optional<Style> createStyles(String style, BigDecimal basePrice);
    
    Optional<Style> updateStyles(String newStyleId, BigDecimal basePrice);

//    Optional<Style> deleteStyles(Style styleId);
}
