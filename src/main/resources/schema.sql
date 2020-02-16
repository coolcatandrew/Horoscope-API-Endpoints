DROP TABLE IF EXISTS Zodiac;
CREATE TABLE Zodiac (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sign VARCHAR(11),
    startMonth INT,
    startDay INT,
    endMonth INT,
    endDay INT
);

DROP TABLE IF EXISTS Horoscope;
CREATE TABLE Horoscope (
    id INT AUTO_INCREMENT PRIMARY KEY,
    zodiacId INT,
    content varchar(5000),
    created DATE DEFAULT CURRENT_DATE,
    source varchar(200)
);