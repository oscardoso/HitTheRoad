CREATE DATABASE great_Application;
USE great_Application;
CREATE TABLE user (
  id INTEGER AUTO_INCREMENT,
  username CHAR(50) UNIQUE,
  password CHAR(50),
  email CHAR(50),
  PRIMARY KEY (id)
);