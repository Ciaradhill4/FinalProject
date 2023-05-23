DROP TABLE IF EXISTS customer_orders;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS length;
DROP TABLE IF EXISTS texture;
DROP TABLE IF exists color;
DROP TABLE IF EXISTS style;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  customer_pk int unsigned NOT NULL AUTO_INCREMENT,
  customer_id varchar(60) NOT NULL,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  phone varchar(20),
  PRIMARY KEY (customer_pk)
);

CREATE TABLE style (
  style_pk int unsigned NOT NULL AUTO_INCREMENT,
  style_id enum('Bob', 'Asymmetrical_Bob', 'Straight', 'Body_Wave', 'Deep_Wave', 'Loose_Wave', 'Tight_Curls') NOT NULL,
  base_price decimal(5, 2) NOT NULL,
  PRIMARY KEY (style_pk)
);

CREATE TABLE color (
  color_pk int unsigned NOT NULL AUTO_INCREMENT,
  color_id enum('ONE', 'ONE_B', 'TWO', 'FOUR', 'TWENTY_SEVEN', 'THIRTY', 'NINETY_NINE_J', 'THREE_FIFTY', 'SIX_THIRTY') NOT NULL,
  name varchar(60) NOT NULL,
  price decimal(5, 2) NOT NULL,
  PRIMARY KEY (color_pk)
);

CREATE TABLE texture (
  texture_pk int unsigned NOT NULL AUTO_INCREMENT,
  texture_id varchar(30) NOT NULL,
  name varchar(60) NOT NULL,
  price decimal(5, 2),
  PRIMARY KEY (texture_pk)
);

CREATE TABLE length (
  length_pk int unsigned NOT NULL AUTO_INCREMENT,
  length_id varchar(30) NOT NULL, 
  price decimal(5, 2) NOT NULL,
  PRIMARY KEY (length_pk)
);

CREATE TABLE orders (
  order_pk int unsigned NOT NULL AUTO_INCREMENT,
  customer_fk int unsigned NOT NULL,
  style_fk int unsigned NOT NULL,
  color_fk int unsigned NOT NULL,
  texture_fk int unsigned NOT NULL,
  length_fk int unsigned NOT NULL,
  price decimal(9, 2) NOT NULL,
  PRIMARY KEY (order_pk),
  FOREIGN KEY (customer_fk) REFERENCES customer (customer_pk) ON DELETE CASCADE,
  FOREIGN KEY (style_fk) REFERENCES style (style_pk) ON DELETE CASCADE,
  FOREIGN KEY (color_fk) REFERENCES color (color_pk) ON DELETE CASCADE,
  FOREIGN KEY (texture_fk) REFERENCES texture (texture_pk) ON DELETE CASCADE,
  FOREIGN KEY (length_fk) REFERENCES length (length_pk) ON DELETE CASCADE
);

CREATE TABLE customer_orders (
  customer_fk int unsigned NOT NULL,
  order_fk int unsigned NOT NULL,
  FOREIGN KEY (customer_fk) REFERENCES customer (customer_pk) ON DELETE CASCADE,
  FOREIGN KEY (order_fk) REFERENCES orders (order_pk) ON DELETE CASCADE
);