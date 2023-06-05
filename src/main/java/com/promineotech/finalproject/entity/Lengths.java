package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lengths {

 
  private Long lengthPK;
  private LengthInches lengthId;
  private int inches;
  private BigDecimal price;
}
