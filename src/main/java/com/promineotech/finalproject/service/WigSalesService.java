package com.promineotech.finalproject.service;

import java.util.List;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;

public interface WigSalesService {

  List<Style> fetchStyles(WigStyle style);


}
