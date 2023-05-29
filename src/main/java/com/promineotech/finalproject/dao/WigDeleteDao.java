package com.promineotech.finalproject.dao;

import java.util.Optional;
import com.promineotech.finalproject.entity.Style;

public interface WigDeleteDao {

  Optional<Style> deleteStyles(Style styleId);

}
