DROP TABLE IF EXISTS ticket;

CREATE TABLE ticket (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  asset_id VARCHAR(250) NOT NULL,
  subject varchar(200) not null,
  description VARCHAR(500) NOT NULL,
  created_at DATE NOT NULL,
  closed_at DATE NOT NULL
);

DROP TABLE IF EXISTS asset;

CREATE TABLE asset (
  id int auto_increment primary key,
  asset_name varchar(100) not null,
  description varchar(400) not null,
  customer_name varchar(100) not null,
  customer_email varchar(100) not null
);