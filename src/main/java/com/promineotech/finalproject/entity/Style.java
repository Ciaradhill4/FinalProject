package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Style implements Comparable<Style>{


  private Long stylePK;
  private WigStyle styleId;
  private BigDecimal basePrice;

  @JsonIgnore
  public Long getStylePK() {
    return stylePK;
  }

  @Override
  public int compareTo(Style that) {
    // TODO Auto-generated method stub
    return Comparator
        .comparing(Style::getStyleId)
        .compare(that, that);
  }

}

