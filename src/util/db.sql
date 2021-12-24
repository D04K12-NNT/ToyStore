create database toy_store;

use toy_store;

CREATE TABLE toys(
	id INT PRIMARY KEY IDENTITY,
	code VARCHAR(12) NOT NULL UNIQUE,
	name NVARCHAR(40) NOT NULL,
	price MONEY NOT NULL,
	description NTEXT,
	receiptDate DATE,
	CHECK (price > 0),
	CHECK (receiptDate <= GETDATE())
);

SELECT * FROM toys;