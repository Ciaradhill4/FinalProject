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
public class DefaultWigDeleteDao implements WigDeleteDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Style> fetchStyle(String styleId){
    log.info("DAO: styleId={}", styleId);
  
    //@formatter:off
    String sql = ""
        + "Select * "
        + "FROM style "
        + "WHERE style_id = :style_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_pk", styleId);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Style.builder()
            .stylePK(rs.getLong("style_pk"))
            .styleId(rs.getString("style_id"))
            .basePrice(new BigDecimal(rs.getString("base_price")))
            .build();
        //@formatter:on
        
      }});
        
}
  
  @Override
  public Optional<Style> deleteStyles(String styleId){
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
