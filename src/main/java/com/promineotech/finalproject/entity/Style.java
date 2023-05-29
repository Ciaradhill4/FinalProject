package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Style {


  private Long stylePK;
  private WigStyle styleId;
  private BigDecimal basePrice;

  @JsonIgnore
  public Long getStylePK() {
    return stylePK;
  }
  
  @JsonIgnore
  public Style style(Style newStyleId) {
    return style(newStyleId);
  }
}

