package com.promineotech.finalproject.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {
  @NotNull 
  @Length(max = 30) 
  @Pattern(regexp = "[\\w\\s]*") 
  private String customer;
  
  
  @NotNull
  @Length(max = 30) 
  @Pattern(regexp = "[\\w\\s]*") 
  private String style;
 
  
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
