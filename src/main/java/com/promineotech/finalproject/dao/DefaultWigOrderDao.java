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
import com.promineotech.finalproject.entity.LengthInches;
import com.promineotech.finalproject.entity.Lengths;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import com.promineotech.finalproject.entity.Styles;
import com.promineotech.finalproject.entity.Texture;
import com.promineotech.finalproject.entity.WigColor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWigOrderDao implements WigOrderDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Orders saveOrders(Customer customer, Styles style, Color name, Texture texture,
      Lengths inches, BigDecimal price) {
//    log.info("DAO: customer_id={}, style_id={}, color_id={}, texture_id={}, length_id={}, price={}",
//                  customer, style, name, texture, inches, price);
    SqlParams params = 
        generateInsertSql(customer, style, name, texture, inches, price);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long orderPK = keyHolder.getKey().longValue();
    saveOrders(customer, orderPK);
    
    // @formatter:off
    return Orders.builder()
        .orderPK(orderPK)
        .customer(customer)
        .style(style)
        .name(name)
        .texture(texture)
        .inches(inches)
        .price(price)
        .build();
    // @formatter:on
    
  
  }

  private void saveOrders(Customer customer, Long orderPK) {
    SqlParams params = generateInsertSql(customer, orderPK);
    jdbcTemplate.update(params.sql, params.source); 
  }
  

  private SqlParams generateInsertSql(Customer customer, Long orderPK) {
    SqlParams params = new SqlParams();
    
    //formatter:off
    params.sql = ""
        + "INSERT INTO customer_orders ("
        + "customer_id, order_fk"
        + ") VALUES ("
        + ":customer_id, :order_fk"
        + ")";
    //formatter:on
    
    
    params.source.addValue("customer_id", customer.getCustomerId());
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
  private SqlParams generateInsertSql(Customer customer, Styles style, Color name, Texture texture,
      Lengths inches, BigDecimal price) {
    // @formatter:off
    String sql = ""
        +"INSERT INTO orders ("
        +"customer_id, style_id, name, texture_id, inches, price"
        +")VALUES ("
        +":customer_id, :style_id, :name, :texture_id, :inches, :price"
        +")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("customer_id", customer.getCustomerId());
    params.source.addValue("style_id", style.getStyleId());
    params.source.addValue("name", name.getName());
    params.source.addValue("texture_id", texture.getTextureId());
    params.source.addValue("inches",inches.getInches());
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
  public Optional<Styles> fetchStyle(String styleId) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM styles "
        + "WHERE style_id = :style_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("style_id", styleId.toString().toUpperCase());

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new StyleResultSetExtractor()));
  }

  @Override
  public Optional<Color> fetchColor(String name) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM color "
        + "WHERE name = :name";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("name", name);

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
  public Optional<Lengths> fetchLength(int inches) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM lengths "
        + "WHERE inches = :inches";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("inches", inches);

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new LengthResultSetExtractor()));
  }
  
  @Override
  public Optional<BigDecimal> fetchPrice(BigDecimal price) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }


class LengthResultSetExtractor implements ResultSetExtractor<Lengths> {
  @Override
  public Lengths extractData(ResultSet rs) throws SQLException {
    rs.next();

    // @formatter:off
      return Lengths.builder()
          .lengthPK(rs.getLong("length_pk"))
          .lengthId(LengthInches.valueOf(rs.getString("length_id")))
          .inches(rs.getInt("inches"))
          .price(rs.getBigDecimal("price"))
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
        .texturePK(rs.getLong("texture_pk"))
          .textureId(rs.getString("texture_id"))
          .name(rs.getString("name"))
          .price(rs.getBigDecimal("price"))
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
          .colorPK(rs.getLong("color_pk"))
          .colorId(WigColor.valueOf(rs.getString("color_id")))
          .name(rs.getString("name"))
          .price(rs.getBigDecimal("price"))
          .build(); 
     // @formatter:on
  }
}


class StyleResultSetExtractor implements ResultSetExtractor<Styles> {
 
  @Override
  public Styles extractData(ResultSet rs) throws SQLException {
    rs.next();

    // @formatter:off
      return Styles.builder()
          .stylePK(rs.getLong("style_pk"))
         .styleId(rs.getString("style_id"))
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
          .customerPK(rs.getLong("customer_pk"))
          .customerId(rs.getString("customer_id"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .phone(rs.getString("phone"))
          .build(); 
     // @formatter:on
  }

//  class SqlParams {
//    String sql;
//    MapSqlParameterSource source = new MapSqlParameterSource();
//
//  }
 }
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  @Override
  public Orders createOrder(OrderRequest orderRequest) {
    log.debug("DAO: orderRequest = {}", orderRequest);
    return createOrder(orderRequest);
  }
}  


