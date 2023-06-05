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
public class Styles {


  private Long stylePK;
  private String styleId;
  private BigDecimal basePrice;

  @JsonIgnore
  public Long getStylePK() {
    return stylePK;
  }
}

