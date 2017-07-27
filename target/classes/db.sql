CREATE DATABASE great_Application;
USE great_Application;
CREATE TABLE user (
  id INTEGER AUTO_INCREMENT,
  username CHAR(50) UNIQUE,
  password CHAR(50),
  email CHAR(50),
  PRIMARY KEY (id)
);
CREATE TABLE role (
  id INTEGER AUTO_INCREMENT,
  type CHAR(50) UNIQUE,
  PRIMARY KEY (id)
);