CREATE TABLE user (
  id bigint NOT NULL,
  birthdate date NOT NULL,
  country varchar(255) DEFAULT NULL,
  gender varchar(255) DEFAULT NULL,
  phoneNumber varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_jreodf78a7pl5qidfh43axdfb (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;