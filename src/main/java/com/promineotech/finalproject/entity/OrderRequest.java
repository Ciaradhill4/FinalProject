package com.promineotech.finalproject.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class OrderRequest {
  
  @NotNull 
  @Length(max = 30) 
  @Pattern(regexp = "[\\w\\s]*") 
  private String customer;
  
  
  @NotNull
  private WigStyle style;
 
  
  @NotNull
  private WigColor color;
  
  @NotNull 
  @Length(max = 30) 
  @Pattern(regexp = "[\\w\\s]*") 
  private String texture;
  
  
  @NotNull 
  @Length(max = 30) 
  @Pattern(regexp = "[\\w\\s0-9]*") 
  private String length;

  
}
