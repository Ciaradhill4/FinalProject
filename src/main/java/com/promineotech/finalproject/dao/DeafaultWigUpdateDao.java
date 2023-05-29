package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DeafaultWigUpdateDao implements WigUpdateDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Optional<Style> updateStyles(Style newStyleId, BigDecimal basePrice) {
 log.info("DAO: newStyleId={}, basePrice={}", newStyleId, basePrice);
    
    //@formatter: off
    String sql = ""
        + "UPDATE style SET style_id = new_style_id "
        + "WHERE style_id = :style_id AND base_price = :base_price";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("new_style_id", newStyleId.toString());
    params.put("base_price", basePrice);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Style.builder().styleId(newStyleId).basePrice(basePrice).build());
  }

}
