package com.promineotech.finalproject.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.finalproject.entity.Styles;

public interface WigDeleteDao {
  
  List<Styles> fetchStyle(Long stylePK);

  Optional<Styles> deleteStyles(Long stylePK);

}
