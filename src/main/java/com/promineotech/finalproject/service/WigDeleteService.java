package com.promineotech.finalproject.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigDeleteService {

  Optional<Style> deleteStyles(String styleId);

  List<Style> fetchStyle(String styleId);

}
