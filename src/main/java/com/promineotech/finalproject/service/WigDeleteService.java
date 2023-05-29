package com.promineotech.finalproject.service;

import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigDeleteService {

  Optional<Style> deleteStyles(Style styleId);

}
