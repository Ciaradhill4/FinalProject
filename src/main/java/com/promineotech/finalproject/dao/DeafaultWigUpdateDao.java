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
public class DeafaultWigUpdateDao implements WigUpdateDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Styles> fetchStyle(Long stylePK){
    log.info("DAO: styleId={}", stylePK);
  
    //@formatter:off
    String sql = ""
        + "Select * "
        + "FROM style "
        + "WHERE style_pk = :style_pk";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_pk", stylePK);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Styles mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Styles.builder()
            .stylePK(rs.getLong("style_pk"))
            .styleId(rs.getString("style_id"))
            .basePrice(new BigDecimal(rs.getString("base_price")))
            .build();
        //@formatter:on
        
      }});
  }        

  @Override
  public Optional<Styles> updateStyles(Long stylePK, String styleId, BigDecimal basePrice) {
 log.info("DAO: stlyePK={}", stylePK);
    
    //@formatter: off
    String sql = ""
        + "UPDATE styles "
        + "SET style_pk = :style_pk, style_id = :style_id, base_price = :base_price "
        + "WHERE style_pk = :style_pk ";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_pk", stylePK);
    params.put("style_id", styleId);
    params.put("base_price", basePrice);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Styles.builder().stylePK(stylePK).styleId(styleId).basePrice(basePrice).build());
  }

}