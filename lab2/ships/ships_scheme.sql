CREATE TABLE Battles (
	name varchar (20) NOT NULL ,
	date datetime NOT NULL 
); 

CREATE TABLE Classes (
	class varchar (50) NOT NULL ,
	type varchar (2) NOT NULL ,
	country varchar (20) NOT NULL ,
	numGuns tinyint NULL ,
	bore real NULL ,
	displacement int NULL 
); 

CREATE TABLE Ships (
	name varchar (50) NOT NULL ,
	class varchar (50) NOT NULL ,
	launched smallint NULL 
); 

CREATE TABLE Outcomes (
	ship varchar (50) NOT NULL ,
	battle varchar (20) NOT NULL ,
	result varchar (10) NOT NULL 
); 

ALTER TABLE Battles ADD 
	CONSTRAINT PK_Battles PRIMARY KEY  CLUSTERED 
	(
		name
	);   

ALTER TABLE Classes ADD 
	CONSTRAINT PK_Classes PRIMARY KEY  CLUSTERED 
	(
		class
	);   

ALTER TABLE Ships ADD 
	CONSTRAINT PK_Ships PRIMARY KEY  CLUSTERED 
	(
		name
	);   

ALTER TABLE Outcomes ADD 
	CONSTRAINT PK_Outcomes PRIMARY KEY  CLUSTERED 
	(
		ship,
		battle
	);   

ALTER TABLE Ships ADD 
	CONSTRAINT FK_Ships_Classes FOREIGN KEY 
	(
		class
	) REFERENCES Classes (
		class
	);

ALTER TABLE Outcomes ADD 
	CONSTRAINT FK_Outcomes_Battles FOREIGN KEY 
	(
		battle
	) REFERENCES Battles (
		name
	);
