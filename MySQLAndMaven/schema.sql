CREATE TABLE Users(
	id int not null auto_increment,
	username varchar(32) UNIQUE,
	password varchar(256) not null,
	PRIMARY KEY(id));

CREATE TABLE Posts(
	id int not null auto_increment,
	title varchar(32),
	descr text NOT NULL,
	CODOwner int,
	PRIMARY KEY(id),
	FOREIGN KEY(CODOwner) REFERENCES Users(id));

INSERT INTO Users (username, password) VALUES
("admin", "12345"),
("test", "1234111115");

INSERT INTO Posts (title, descr, CODOwner) VALUES
("Primo post", "Hello World!", 1),
("Secondo post", "Test", 1);

SELECT * FROM Users;
SELECT * FROM Posts;