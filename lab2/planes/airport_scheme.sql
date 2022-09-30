CREATE TABLE Company (
	ID_comp int NOT NULL ,
	name char (10) NOT NULL 
);

CREATE TABLE Pass_in_trip (
	trip_no int NOT NULL ,
	date datetime NOT NULL ,
	ID_psg int NOT NULL ,
	place char (10) NOT NULL 
);

CREATE TABLE Passenger (
	ID_psg int NOT NULL ,
	name char (20) NOT NULL 
);

CREATE TABLE Trip (
	trip_no int NOT NULL ,
	ID_comp int NOT NULL ,
	plane char (10) NOT NULL ,
	town_from char (25) NOT NULL ,
	town_to char (25) NOT NULL ,
	time_out datetime NOT NULL ,
	time_in datetime NOT NULL 
);

ALTER TABLE Company ADD 
	CONSTRAINT PK2 PRIMARY KEY  CLUSTERED 
	(
		ID_comp
	);   

ALTER TABLE Pass_in_trip ADD 
	CONSTRAINT PK_pt PRIMARY KEY  CLUSTERED 
	(
		trip_no,
		date,
		ID_psg
	);   

ALTER TABLE Passenger ADD 
	CONSTRAINT PK_psg PRIMARY KEY  CLUSTERED 
	(
		ID_psg
	);   

ALTER TABLE Trip ADD 
	CONSTRAINT PK_t PRIMARY KEY  CLUSTERED 
	(
		trip_no
	);   

ALTER TABLE Pass_in_trip ADD 
	CONSTRAINT FK_Pass_in_trip_Passenger FOREIGN KEY 
	(ID_psg) REFERENCES Passenger (ID_psg);
ALTER TABLE Pass_in_trip ADD     
	CONSTRAINT FK_Pass_in_trip_Trip FOREIGN KEY 
	(trip_no) REFERENCES Trip (trip_no);
 
ALTER TABLE Trip ADD 
	CONSTRAINT FK_Trip_Company FOREIGN KEY 
	(
		ID_comp
	) REFERENCES Company (
		ID_comp
	);
