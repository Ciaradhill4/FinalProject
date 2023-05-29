package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWigDeleteDao implements WigDeleteDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Optional<Style> deleteStyles(Style styleId){
    //@formatter:off
    String sql = ""
        + "DELETE FROM style WHERE "
        + " style_id = :style_id AND "
        + "base_price = :base_price";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_id", styleId.toString());
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Style.builder().styleId(styleId).build());
  }

}
