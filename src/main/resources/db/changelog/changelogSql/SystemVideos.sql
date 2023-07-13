CREATE TABLE Responsavel (
	IdResponsavel		int		identity,
	NomeResponsavel		varchar(255)	NOT NULL,
);

ALTER TABLE Responsavel
ADD CONSTRAINT PK_Responsavel PRIMARY KEY (IdResponsavel);

CREATE TABLE Categoria (
	IdCategoria		int		identity,
	NomeCategoria		varchar(255)	NOT NULL,
);

ALTER TABLE Categoria
ADD CONSTRAINT PK_Categoria PRIMARY KEY (IdCategoria);

CREATE TABLE Video (
	IdVideo			int		identity,
	TituloVideo		nvarchar(255)   NOT NULL,
	URL			nvarchar(2083)	NOT NULL,
	IdadeMinima		tinyint		NOT NULL,
	IdResponsavel		int		NOT NULL,
	IdCategoria         	int
);

ALTER TABLE Video
ADD CONSTRAINT FK_Video_Responsavel FOREIGN KEY (IdResponsavel)
REFERENCES Responsavel (IdResponsavel);

ALTER TABLE Video
ADD CONSTRAINT FK_Video_Categoria FOREIGN KEY (IdCategoria)
REFERENCES Categoria (IdCategoria);
