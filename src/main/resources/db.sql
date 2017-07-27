CREATE DATABASE hit_the_road;
USE hit_the_road;
CREATE TABLE user (
  id INTEGER AUTO_INCREMENT,
  username CHAR(50) UNIQUE,
  password CHAR(50),
  email CHAR(50),
  PRIMARY KEY (id)
);
CREATE TABLE supplies (
  id INTEGER AUTO_INCREMENT,
  name CHAR(50) UNIQUE,
  PRIMARY KEY (id)
);