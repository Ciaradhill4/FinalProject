package com.promineotech.finalproject.service;

import java.util.Optional;
import com.promineotech.finalproject.entity.Styles;

public interface WigDeleteService {

  Optional<Styles> deleteStyles(Long styleId);

 // List<Styles> fetchStyle(String styleId);

}
