package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {

  private Long orderPK;
  private Customer customer;
  private WigStyle style;
  private WigColor color;
  private Texture texture;
  private Length length;
  private BigDecimal price;
}

