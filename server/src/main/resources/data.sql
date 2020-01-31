DROP TABLE IF EXISTS bet;
DROP TABLE IF EXISTS game;



CREATE TABLE bet
(
  id                 INT AUTO_INCREMENT PRIMARY KEY,
  name               VARCHAR(250) NOT NULL,
  photo_url          VARCHAR(250)
);

CREATE TABLE game
(
  id                 INT AUTO_INCREMENT PRIMARY KEY,
  user_Choice        VARCHAR(250) NOT NULL,
  curb_Choice        VARCHAR(250),
  winner             VARCHAR(250)
);

INSERT INTO bet (name, photo_url)
VALUES ('Paper', '../../../../assets/Paper.svg'),
       ('Rock', '../../../../assets/Rock.svg'),
       ('Scissors', '../../../../assets/Scissors.svg');

