package com.promineotech.finalproject.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigDeleteDao {

  Optional<Style> deleteStyles(String styleId);

  List<Style> fetchStyle(String styleId);

}
