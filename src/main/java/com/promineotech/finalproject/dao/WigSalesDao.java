package com.promineotech.finalproject.dao;

import java.util.List;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;

public interface WigSalesDao {

  /**
   * 
   * @param styles
   * @return
   */
  List<Style> fetchStyles(WigStyle styles);

}
