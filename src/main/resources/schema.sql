/**
 Author: nasheikh
 Model : blogapp
**/

DROP SCHEMA IF EXISTS blogapp;

CREATE SCHEMA blogapp;
USE blogapp;


/* Table: blogpost */
CREATE TABLE posts (
  id       INT NOT NULL,
  title    VARCHAR(50) ,
  content     LONGTEXT,
  author VARCHAR(50),
  image bytea,
  created_at  DATETIME ,
  updated_at DATETIME,
  PRIMARY KEY (id)
);

/* Table: action table to capture likes and comments */
CREATE TABLE comments (
  id       INT NOT NULL,
  author NVARCHAR(20),
  post_id    INT ,
  content     VARCHAR(250),
  PRIMARY KEY (id)
);


/* Table: action table to capture likes and comments */
CREATE TABLE action (
  id       INT NOT NULL,
  user_id NVARCHAR(20),
  post_id    INT ,
  action_type     VARCHAR(20),
  comments VARCHAR(250),
  image bytea,
  created_at       DATETIME ,
  updated_at DATETIME,
  PRIMARY KEY (id)
);

CREATE SEQUENCE POST_ID_SEQ START WITH 100;
CREATE SEQUENCE COMMENT_ID_SEQ START WITH 100;


ALTER TABLE comments ADD CONSTRAINT fk_comments_post FOREIGN KEY (post_id) REFERENCES posts(id);

/* Table: user (Application Users) */
CREATE TABLE user (
    user_id     NVARCHAR(20) NOT NULL,
    password    NVARCHAR(20) NOT NULL,
    first_name  NVARCHAR(50) ,
    last_name   NVARCHAR(50) ,
    email       NVARCHAR(70) ,
    security_provider_id INT ,
    default_customer_id  INT ,
    company     NVARCHAR(50) ,
    phone       NVARCHAR(20) ,
    address1    NVARCHAR(100),
    address2    NVARCHAR(100),
    country     NVARCHAR(20) ,
    postal      NVARCHAR(20) ,
    role        NVARCHAR(20) ,
    other_roles NVARCHAR(80) ,
    is_active   TINYINT  ,
    is_blocked  TINYINT  ,
    secret_question     NVARCHAR(100),
    secret_answer       NVARCHAR(100),
    enable_beta_testing TINYINT,
    enable_renewal      TINYINT,
    CONSTRAINT user_id PRIMARY KEY(user_id)
);



/* Table: products */
CREATE TABLE accounts (
  id              INT NOT NULL,
  product_code    VARCHAR(25) ,
  product_name    VARCHAR(50) ,
  description     VARCHAR(250),
  standard_cost   DECIMAL(19,4) NULL DEFAULT '0.0000',
  list_price      DECIMAL(19,4) NOT NULL DEFAULT '0.0000',
  target_level    INT ,
  reorder_level   INT ,
  minimum_reorder_quantity INT ,
  quantity_per_unit VARCHAR(50) ,
  discontinued    TINYINT NOT NULL DEFAULT '0',
  category        VARCHAR(50),
  PRIMARY KEY (id)
);
