CREATE DATABASE 308OGS ;
use 308OGS;

CREATE TABLE User (
	Username VARCHAR(20), 
	Password VARCHAR(20),
	FirstName VARCHAR(20),
	LastName VARCHAR(20),
	Email VARCHAR(50),
	Role VARCHAR(20),
	PRIMARY KEY (Username)
)

CREATE TABLE Course(
	CrsCode VARCHAR(6),
	CrsName VARCHAR(20),
	PRIMARY KEY (CrsCode)
)

CREATE TABLE Assignment(
	ID VARCHAR(20),
	Name VARCHAR(20),
	Duedate DATETIME NOT NULL,
	Pts INT,
	Description VARCHAR(100),
	PRIMARY KEY (ID)
)

CREATE TABLE GradeCenter(
	CrsCode VARCHAR(6),
	PRIMARY KEY (CrsCode),
	FOREIGN KEY (CrsCode) REFERENCES Course (CrsCode) ON DELETE CASCADE
)

CREATE TABLE Teaching(
	Username VARCHAR(20),
	CrsCode VARCHAR(6),
	PRIMARY KEY (Username,CrsCode),
	FOREIGN KEY (Username) REFERENCES User(Username) ON DELETE CASCADE,
	FOREIGN KEY (CrsCode) REFERENCES Course (CrsCode) ON DELETE CASCADE
)

CREATE TABLE Assisting(
	Username VARCHAR(20),
	CrsCode VARCHAR(6),
	PRIMARY KEY (Username,CrsCode),
	FOREIGN KEY (Username) REFERENCES User(Username) ON DELETE CASCADE,
	FOREIGN KEY (CrsCode) REFERENCES Course (CrsCode) ON DELETE CASCADE
)

CREATE TABLE Registered(
	Username VARCHAR(20),
	CrsCode VARCHAR(6),
	PRIMARY KEY (Username,CrsCode),
	FOREIGN KEY (Username) REFERENCES User(Username) ON DELETE CASCADE,
	FOREIGN KEY (CrsCode) REFERENCES Course (CrsCode) ON DELETE CASCADE
)

CREATE TABLE HasAssignment(
	CrsCode VARCHAR(6),
	AssiID VARCHAR(20),
	PRIMARY KEY (CrsCode, AssiID),
	FOREIGN KEY (CrsCode) REFERENCES Course (CrsCode) ON DELETE CASCADE,
	FOREIGN KEY (AssiID) REFERENCES Assignment (ID) ON DELETE CASCADE
)


--Store submission in this table, need to create a column but I am not sure how to make it work
CREATE TABLE Submission(
	Username VARCHAR(20),
	AssiID VARCHAR(20),
	PRIMARY KEY(Username, AssiID),
	FOREIGN KEY (Username) REFERENCES User(Username) ON DELETE CASCADE,
	FOREIGN KEY (AssiID) REFERENCES Assignment (ID) ON DELETE CASCADE
)


	









	