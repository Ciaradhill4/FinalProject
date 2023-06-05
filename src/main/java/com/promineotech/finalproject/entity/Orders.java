package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {

  private Long orderPK;
  private Customer customer;
  private Styles style;
  private Color name;
  private Texture texture;
  private Lengths inches;
  private BigDecimal price;
  
  
  @JsonIgnore
  public Long getorderPK() {
    return orderPK;
  }

}

