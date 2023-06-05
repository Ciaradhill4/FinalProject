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
public class DefaultWigDeleteDao implements WigDeleteDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Styles> fetchStyle(Long stylePK){
    log.info("DAO: style={}", stylePK);
  
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
  public Optional<Styles> deleteStyles(Long stylePK){
    //@formatter:off
    String sql = ""
        + "DELETE FROM styles "
        + "WHERE style_pk = :style_pk ";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("style_pk", stylePK);
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Styles.builder().stylePK(stylePK).build());
  }

}
