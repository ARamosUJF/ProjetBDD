CREATE TABLE LesSpectacles(
NumSpec INT NOT NULL,
NomSpec VARCHAR(30) NOT NULL,
PRIMARY KEY (NumSpec));

CREATE TABLE LesRepresentations(
NumSpec INT,
DateRep VARCHAR(30) NOT NULL,
FOREIGN KEY (NumSpec) REFERENCES LesSpectacles (NumSpec),
CONSTRAINT PK_Rep PRIMARY KEY (NumSpec, DateRep));

CREATE TABLE CategorieTarif(
NumCatTarif INT NOT NULL,
Prix FLOAT NOT NULL,
NomCatTarif VARCHAR(30) NOT NULL,
PRIMARY KEY (NumCatTarif));

CREATE TABLE LesZones(
NumZone INT NOT NULL,
NumCatTarif INT NOT NULL,
FOREIGN KEY (NumCatTarif) REFERENCES CategorieTarif (NumCatTarif),
PRIMARY KEY (NumZone));

CREATE TABLE LesPlaces(
NumPlace INT NOT NULL,
NumRang INT NOT NULL,
NumZone INT,
FOREIGN KEY (NumZone) REFERENCES LesZones (NumZone),
CONSTRAINT PK_Places PRIMARY KEY (NumPlace, NumRang));

CREATE TABLE Ticket(
NumTicket INT NOT NULL,
PRIMARY KEY (NumTicket));

CREATE TABLE LesDossiers(
NumDossier INT,
PrixTotal FLOAT,
DateTransaction VARCHAR(30),
NumTicket INT,
FOREIGN KEY (NumTicket) REFERENCES Ticket (NumTicket),
PRIMARY KEY (NumDossier));
