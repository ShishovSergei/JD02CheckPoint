CREATE TABLE cast_members
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  name       VARCHAR(45)                NOT NULL,
  surname    VARCHAR(45)                NOT NULL,
  birthday   VARCHAR(45)                NULL,
  gender     ENUM ('MAN', 'WOMAN')      NOT NULL,
  type       ENUM ('ACTOR', 'DIRECTOR') NOT NULL,
  studio     VARCHAR(45)                NULL,
  understudy VARCHAR(45)                NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE TABLE cinemas
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  city        VARCHAR(45) NOT NULL,
  street      VARCHAR(45) NOT NULL,
  name        VARCHAR(45) NOT NULL,
  description VARCHAR(45) NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE TABLE film_format
(
  id     INT AUTO_INCREMENT
    PRIMARY KEY,
  format VARCHAR(8) NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE TABLE film_genres
(
  id    INT AUTO_INCREMENT
    PRIMARY KEY,
  genre VARCHAR(45) NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE TABLE films
(
  id           INT AUTO_INCREMENT
    PRIMARY KEY,
  title        VARCHAR(20)  NOT NULL,
  release_date DATE         NOT NULL,
  description  VARCHAR(300) NULL,
  country      VARCHAR(45)  NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE TABLE films_has_cast_members
(
  films_id        INT NOT NULL,
  cast_members_id INT NOT NULL,
  PRIMARY KEY (films_id, cast_members_id),
  CONSTRAINT FKeqtw3akdtv9rgqs3evfqib78o
  FOREIGN KEY (films_id) REFERENCES films (id),
  CONSTRAINT FKh8a94lwfqxxeceq96ewjee1ax
  FOREIGN KEY (cast_members_id) REFERENCES cast_members (id)
)
  ENGINE = InnoDB;

CREATE INDEX FKh8a94lwfqxxeceq96ewjee1ax
  ON films_has_cast_members (cast_members_id);

CREATE TABLE films_has_film_genres
(
  films_id       INT NOT NULL,
  film_genres_id INT NOT NULL,
  PRIMARY KEY (films_id, film_genres_id),
  CONSTRAINT FKdnx52annrtm9m84pht3u4k9gv
  FOREIGN KEY (films_id) REFERENCES films (id),
  CONSTRAINT FKlh4utaq074vxednb9ebhltls3
  FOREIGN KEY (film_genres_id) REFERENCES film_genres (id)
)
  ENGINE = InnoDB;

CREATE INDEX FKlh4utaq074vxednb9ebhltls3
  ON films_has_film_genres (film_genres_id);

CREATE TABLE halls
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  capacity   INT NOT NULL,
  cinemas_id INT NOT NULL,
  CONSTRAINT FKou8ffpji5dira798i18o5fpmn
  FOREIGN KEY (cinemas_id) REFERENCES cinemas (id),
  CONSTRAINT fk_halls_cinemas1
  FOREIGN KEY (cinemas_id) REFERENCES cinemas (id)
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE INDEX fk_halls_cinemas1_idx
  ON halls (cinemas_id);

CREATE TABLE hibernate_sequences
(
  sequence_name VARCHAR(255) NOT NULL
    PRIMARY KEY,
  next_val      BIGINT       NULL
)
  ENGINE = InnoDB;

CREATE TABLE seances
(
  id             INT AUTO_INCREMENT
    PRIMARY KEY,
  date           DATE        NOT NULL,
  time           TIME        NOT NULL,
  films_id       INT         NOT NULL,
  film_format_id INT         NOT NULL,
  age_limit      VARCHAR(10) NOT NULL,
  halls_id       INT         NOT NULL,
  CONSTRAINT FKck4umx7to9yjg3il447ld3d4k
  FOREIGN KEY (films_id) REFERENCES films (id),
  CONSTRAINT fk_seances_films1
  FOREIGN KEY (films_id) REFERENCES films (id),
  CONSTRAINT FKcl3k69vqill2clf1jrd215btj
  FOREIGN KEY (film_format_id) REFERENCES film_format (id),
  CONSTRAINT fk_seances_film_format1
  FOREIGN KEY (film_format_id) REFERENCES film_format (id),
  CONSTRAINT FKnwq6xbwil3kv4vsvuou6sx32q
  FOREIGN KEY (halls_id) REFERENCES halls (id),
  CONSTRAINT fk_seances_halls1
  FOREIGN KEY (halls_id) REFERENCES halls (id)
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE INDEX fk_seances_films1_idx
  ON seances (films_id);

CREATE INDEX fk_seances_film_format1_idx
  ON seances (film_format_id);

CREATE INDEX fk_seances_halls1_idx
  ON seances (halls_id);

CREATE TABLE tickets
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  place      INT   NOT NULL,
  price      FLOAT NOT NULL,
  seances_id INT   NULL,
  users_id   INT   NULL,
  CONSTRAINT UK_apmhfqsoercr7hakuxt5371dw
  UNIQUE (place),
  CONSTRAINT FKboa5aogj2m9watvlnupev41cu
  FOREIGN KEY (seances_id) REFERENCES seances (id)
)
  ENGINE = InnoDB;

CREATE INDEX FKboa5aogj2m9watvlnupev41cu
  ON tickets (seances_id);

CREATE INDEX FK384xu0lexsjs1mqhaj0cese1t
  ON tickets (users_id);

CREATE TABLE users
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  email    VARCHAR(255) NULL,
  login    VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  type     VARCHAR(255) NOT NULL,
  CONSTRAINT UK_6dotkott2kjsp8vw4d0m25fb7
  UNIQUE (email),
  CONSTRAINT UK_ow0gan20590jrb00upg3va2fn
  UNIQUE (login)
)
  ENGINE = InnoDB;

ALTER TABLE tickets
  ADD CONSTRAINT FK384xu0lexsjs1mqhaj0cese1t
FOREIGN KEY (users_id) REFERENCES users (id);