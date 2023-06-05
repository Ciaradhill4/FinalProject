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
import com.promineotech.finalproject.entity.Styles;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWigSalesDao implements WigSalesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  //Get method to read list of styles from database
  @Override
  public List<Styles> fetchStyles(Long stylePK) {
    log.info("DAO: styleId={}", stylePK);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM styles "
        + "WHERE style_pk = :style_pk";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_pk", stylePK);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {

          @Override
          public Styles mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Styles.builder()
                .stylePK(rs.getLong("style_pk"))
                .styleId(rs.getString("style_id").toUpperCase())
                .basePrice(new BigDecimal(rs.getString("base_price")))
                .build();
            //@formatter:on
          }});
  }

  @Override
  public Optional<Styles> createStyles(Long stylePK, String styleId, BigDecimal basePrice){
    log.info("DAO: style={}, basePrice={}", styleId, basePrice);
    
    //@formatter:off
    String sql = ""
        + "INSERT INTO styles ("
        + "style_pk, style_id, base_price"
        + ") VALUES ("
        +  ":style_pk, :style_id, :base_price)";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_id", styleId);
    params.put("base_price", basePrice);
 
 
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Styles.builder().stylePK(stylePK).styleId(styleId).basePrice(basePrice).build());    
  }
  
  @Override
  public Optional<Styles> updateStyles(String newStyleId, BigDecimal basePrice){
    log.info("DAO: styleId={}, basePrice={}", newStyleId, basePrice);
    
    //@formatter: off
    String sql = ""
        + "UPDATE style "
        + "SET style_id = new_style_id "
        + "WHERE style_id = :style_id, base_price = :base_price";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_id", newStyleId.toString());
    params.put("base_price", basePrice);
    params.put("new_wig_style", newStyleId.toString());
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Styles.builder().styleId(newStyleId).basePrice(basePrice).build());
  }

}
