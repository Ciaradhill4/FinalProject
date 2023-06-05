package com.promineotech.finalproject.service;

import java.util.List;
import com.promineotech.finalproject.entity.Styles;

public interface WigSalesService {

  List<Styles> fetchStyles(Long stylePK);

//    Optional<Styles> createStyles(String style, BigDecimal basePrice);
//    
//    Optional<Styles> updateStyles(String newStyleId, BigDecimal basePrice);

//    Optional<Style> deleteStyles(Style styleId);
}
