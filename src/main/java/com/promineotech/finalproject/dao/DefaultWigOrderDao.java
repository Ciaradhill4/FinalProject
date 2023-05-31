package com.promineotech.finalproject.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.finalproject.entity.Color;
import com.promineotech.finalproject.entity.Customer;
import com.promineotech.finalproject.entity.Length;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.Texture;
import com.promineotech.finalproject.entity.WigColor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWigOrderDao implements WigOrderDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Orders saveOrder(Customer customer, Style style, Color color, Texture texture,
      Length length, BigDecimal price) {
    SqlParams params = 
        generateInsertSql(customer, style, color, texture, length, price);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long orderPK = keyHolder.getKey().longValue();
    saveOptions(customer, orderPK);
    
    // @formatter:off
    return Orders.builder()
        .orderPK(orderPK)
        .customer(customer)
        .style(style)
        .color(color)
        .texture(texture)
        .length(length)
        .price(price)
        .build();
    // @formatter:on
    
  
  }

  private void saveOptions(Customer customer, Long orderPK) {
    SqlParams params = generateInsertSql(customer, orderPK);
    jdbcTemplate.update(params.sql, params.source); 
  }

  private SqlParams generateInsertSql(Customer customer, Long orderPK) {
    SqlParams params = new SqlParams();
    
    //formatter:off
    params.sql = ""
        + "INSERT INTO customer_orders ("
        + "customer_fk, order_fk"
        + ") VALUES ("
        + ":customer_fk, :order_fk"
        + ")";
    //formatter:on
    
    params.source.addValue("customer_fk", customer);
    params.source.addValue("order_fk", orderPK);
    
    return params;
  }

  /**
   * 
   * @param customer
   * @param style
   * @param color
   * @param texture
   * @param length
   * @param price
   * @return
   */
  private SqlParams generateInsertSql(Customer customer, Style style, Color color, Texture texture,
      Length length, BigDecimal price) {
    // @formatter:off
    String sql = ""
        +"INSERT INTO orders ("
        +"customer_fk, style_fk, color_fk, texture_fk, length_fk, price"
        +")VALUES ("
        +":customer_fk, :style_fk, :color_fk, :texture_fk, :length_fk, :price)"
        +"";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("customer_fk", customer.getCustomerPK());
    params.source.addValue("style_fk", style.getStylePK());
    params.source.addValue("color_fk", color.getcolorPK());
    params.source.addValue("texture_fk", texture.getTexturePK());
    params.source.addValue("length_fk", length.getLengthPK());
    params.source.addValue("price", price);
    
    return params;
  }

  /**
   * 
   */
  @Override
  public Optional<Customer> fetchCustomer(String customerId) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customer "
        + "WHERE customer_id = :customer_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }

  @Override
  public Optional<Style> fetchStyle(String styleId) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM style "
        + "WHERE style_id = :style_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("style_id", styleId.toString().toUpperCase());

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new StyleResultSetExtractor()));
  }

  @Override
  public Optional<Color> fetchColor(WigColor colorId) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM color "
        + "WHERE color_id = :color_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("color_id", colorId.toString().toUpperCase());

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new ColorResultSetExtractor()));
  }

  @Override
  public Optional<Texture> fetchTexture(String textureId) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM texture "
        + "WHERE texture_id = :texture_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("texture_id", textureId);

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new TextureResultSetExtractor()));
  }

  @Override
  public Optional<Length> fetchLength(String lengthId) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM length "
        + "WHERE length_id = :length_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("length_id", lengthId);

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new LengthResultSetExtractor()));
  }


class LengthResultSetExtractor implements ResultSetExtractor<Length> {
  @Override
  public Length extractData(ResultSet rs) throws SQLException {
    rs.next();

    // @formatter:off
      return Length.builder()
          .lengthId(rs.getString("length_id"))
          .lengthPK(rs.getLong("length_pk"))
          .price(rs.getBigDecimal("base_price"))
          .build(); 
     // @formatter:on
  }
}


class TextureResultSetExtractor implements ResultSetExtractor<Texture> {
  @Override
  public Texture extractData(ResultSet rs) throws SQLException {
    rs.next();

    // @formatter:off
      return Texture.builder()
          .textureId(rs.getString("texture_id"))
          .texturePK(rs.getLong("texture_pk"))
          .name(rs.getString("name"))
          .price(rs.getBigDecimal("base_price"))
          .build(); 
     // @formatter:on
  }
}


class ColorResultSetExtractor implements ResultSetExtractor<Color> {
  @Override
  public Color extractData(ResultSet rs) throws SQLException {
    rs.next();

    // @formatter:off
      return Color.builder()
          .colorId(WigColor.valueOf(rs.getString("color_id")))
          .colorPK(rs.getLong("color_pk"))
          .name(rs.getString("name"))
          .price(rs.getBigDecimal("base_price"))
          .build(); 
     // @formatter:on
  }
}


class StyleResultSetExtractor implements ResultSetExtractor<Style> {
 
  @Override
  public Style extractData(ResultSet rs) throws SQLException {
    rs.next();

    // @formatter:off
      return Style.builder()
          .styleId(rs.getString("style_id"))
          .stylePK(rs.getLong("style_pk"))
          .basePrice(rs.getBigDecimal("base_price"))
          .build(); 
     // @formatter:on
  }
}


class CustomerResultSetExtractor implements ResultSetExtractor<Customer> {
 
  @Override
  public Customer extractData(ResultSet rs) throws SQLException {
    rs.next();

    // @formatter:off
      return Customer.builder()
          .customerId(rs.getString("customer_id"))
          .customerPK(rs.getLong("customer_pk"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .phone(rs.getString("phone"))
          .build(); 
     // @formatter:on
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();

  }
 }
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  @Override
  public Orders createOrder(OrderRequest orderRequest) {
    log.debug("Order = {}", orderRequest);
    return createOrder(orderRequest);
  }
  
}


