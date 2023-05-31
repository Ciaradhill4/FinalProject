package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.finalproject.entity.Style;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWigSalesDao implements WigSalesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  //Get method to read list of styles from database
  @Override
  public List<Style> fetchStyles(String style) {
    log.info("DAO: styleId={}", style);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM style "
        + "WHERE style_id = :style_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_id", style.toString());
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {

          @Override
          public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Style.builder()
                .stylePK(rs.getLong("style_pk"))
                .styleId(rs.getString("style_id").toUpperCase())
                .basePrice(new BigDecimal(rs.getString("base_price")))
                .build();
            //@formatter:on
          }});
  }

  @Override
  public Optional<Style> createStyles(String style, BigDecimal basePrice){
    log.info("DAO: style={}, basePrice={}", style, basePrice);
    
    //@formatter:off
    String sql = ""
        + "INSERT INTO style ("
        + "style_id, base_price"
        + ") VALUES ("
        +  ":style_id, :base_price)";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_id", style.toString());
    params.put("base_price", basePrice);
 
 
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Style.builder().styleId(style).basePrice(basePrice).build());    
  }
  
  @Override
  public Optional<Style> updateStyles(String newStyleId, BigDecimal basePrice){
    log.info("DAO: styleId={}, basePrice={}", newStyleId, basePrice);
    
    //@formatter: off
    String sql = ""
        + "UPDATE style SET style_id = new_wig_style "
        + "WHERE style_id = :style_id AND base_price = :base_price";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_id", newStyleId.toString());
    params.put("base_price", basePrice);
    params.put("new_wig_style", newStyleId.toString());
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Style.builder().styleId(newStyleId).basePrice(basePrice).build());
  }

}
