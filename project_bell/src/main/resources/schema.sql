CREATE TABLE IF NOT EXISTS User (
  id            INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version       INTEGER      NOT NULL,
  first_name    VARCHAR(50) NOT NULL,
  second_name   VARCHAR(50) NOT NULL,
  middle_name   VARCHAR(50) NOT NULL,
  position      VARCHAR(50),
  phone         VARCHAR(50),
  doc_id        INT UNSIGNED NOT NULL,
  country_id    INT UNSIGNED NOT NULL,
  office_id     INT UNSIGNED NOT NULL,
  is_identified BOOLEAN,
  FOREIGN KEY (office_id) REFERENCES Office(id),
  FOREIGN KEY (doc_id) REFERENCES Document(id),
  FOREIGN KEY (countrie_id) REFERENCES Country(id)
);

CREATE TABLE IF NOT EXISTS Office (
  id              INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version         INTEGER      NOT NULL,
  name            VARCHAR(50) NOT NULL,
  address         VARCHAR(50)  NOT NULL,
  phone           VARCHAR(50),
  org_id INT UNSIGNED NOT NULL,
  is_active       BOOLEAN,
  FOREIGN KEY (org_id) REFERENCES Organization(id)
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
  is_active BOOLEAN
);


CREATE TABLE IF NOT EXISTS Document (
  id          INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version     INTEGER      NOT NULL,
  number      VARCHAR,
  date        VARCHAR(11)   NOT NULL
  doc_type_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (doc_type_id) REFERENCES Doc_Type(id)
);


CREATE TABLE IF NOT EXISTS Doc_Type (
  id      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  code    VARCHAR(6)   NOT NULL,
  name    VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS Country (
  id      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  code    VARCHAR(6),
  name    VARCHAR(50) NOT NULL
);


CREATE INDEX IX_Office_Organization_Id ON Office (organization_id);

CREATE INDEX IX_User_Doc_Id ON User (doc_id);

CREATE INDEX IX_User_Office_Id ON User (office_id);

CREATE INDEX IX_User_Country_Id ON User (country_id);

CREATE INDEX IX_Document_Doc_Type_Id ON Document (doc_type_id);

ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);

ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office (id);

ALTER TABLE User ADD FOREIGN KEY (doc_id) REFERENCES Document (id);

ALTER TABLE User ADD FOREIGN KEY (country_id) REFERENCES Country (id);

ALTER TABLE Document ADD FOREIGN KEY (doc_type_id) REFERENCES Doc_Type (id);