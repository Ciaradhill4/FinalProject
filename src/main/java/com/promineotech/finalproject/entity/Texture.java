package com.promineotech.finalproject.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;


@Data 
@Builder 
public class Texture {

 
  private Long texturePK;
  private String textureId;
  private String name;
  private BigDecimal price;
}
