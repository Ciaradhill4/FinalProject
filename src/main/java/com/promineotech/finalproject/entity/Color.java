package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Color implements Comparable<Color>{
  private Long colorPK;
  private WigColor colorId;
  private String name;
  private BigDecimal price;
  
  @JsonIgnore
  public Long getcolorPK() {
    return colorPK;
  }
  
  @Override
  public int compareTo(Color that) {
    // @formatter: off
    return Comparator
        .comparing(Color::getColorId)
        .compare(that, that);
    // @formatter: on
  }

}
