package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Options {
  private Long optionPK;
  private String optionId;
  private String location;
  private BigDecimal price;
}
