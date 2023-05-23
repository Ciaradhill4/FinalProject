package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWigSalesDao implements WigSalesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdcbTemplate;

  @Override
  public List<Style> fetchStyles(WigStyle style) {
    log.debug("DAO: style={}", style);
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM style "
        + "WHERE style_id = :style_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_id", style.toString());
    
    return jdcbTemplate.query(sql, 
        new RowMapper<>() {

          @Override
          public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Style.builder()
                .stylePK(rs.getLong("style_pk"))
                .styleId(WigStyle.valueOf(rs.getString("style_id")))
                .basePrice(new BigDecimal(rs.getString("base_price")))
                .build();
            //@formatter:on
          }});
  }

}
