




CREATE TABLE IF NOT EXISTS User (
  id            INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version       INTEGER      NOT NULL,
  first_name    VARCHAR(50) NOT NULL,
  second_name   VARCHAR(50) NOT NULL,
  middle_name   VARCHAR(50) NOT NULL,
  position      VARCHAR(50) NOT NULL,
  phone         VARCHAR(50),
  country_id    INTEGER ,
  office_id     INTEGER ,
  is_identified  BOOLEAN

);

CREATE TABLE IF NOT EXISTS Document (
  id          INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version     INTEGER      NOT NULL,
  number      VARCHAR(11)   NOT NULL,
  date        VARCHAR(11)   NOT NULL,
  doc_type_id INTEGER

);

CREATE TABLE IF NOT EXISTS Country (
  id      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  code    VARCHAR(6),
  name    VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Doc_Type (
  id      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  code    VARCHAR(6)   NOT NULL,
  name    VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER      NOT NULL,
  name      VARCHAR(50) NOT NULL,
  full_name VARCHAR(50) NOT NULL,
  inn       VARCHAR(50) UNIQUE,
  kpp       VARCHAR(50),
  address   VARCHAR(50),
  phone     VARCHAR(50),
  is_active  BOOLEAN
);


CREATE TABLE IF NOT EXISTS Office (
  id              INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version         INTEGER      NOT NULL,
  name            VARCHAR(50) NOT NULL,
  address         VARCHAR(50)  NOT NULL,
  phone           VARCHAR(50),
  org_id          INTEGER,
  is_active        BOOLEAN

);







CREATE INDEX IX_User_id
  ON User (id);
ALTER TABLE User
  ADD FOREIGN KEY (id) REFERENCES Document (id);


CREATE INDEX IX_User_country_id ON User (country_id);
ALTER TABLE User ADD FOREIGN KEY (country_id) REFERENCES Country (id);


CREATE INDEX IX_User_office_id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office (id);

CREATE INDEX IX_Document_doc_type_id ON Document (doc_type_id);
ALTER TABLE Document ADD FOREIGN KEY (doc_type_id) REFERENCES Doc_type (id);


CREATE INDEX IX_Office_org_id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization (id);


