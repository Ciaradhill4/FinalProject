package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Length {

 
  private Long lengthPK;
  private String lengthId;
  private BigDecimal price;
}
