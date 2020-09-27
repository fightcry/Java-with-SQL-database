IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Pracownik'))
BEGIN
  CREATE TABLE Pracownik (
  idPracownik INTEGER NOT NULL IDENTITY,
  imie VARCHAR(30) NOT NULL,
  nazwisko VARCHAR(30) NOT NULL,
  PESEL CHAR(11) NOT NULL,
  pensja FLOAT NOT NULL,
  stanowisko VARCHAR(30) NOT NULL,
  data_zatrudnienia DATE NULL,
  data_urodzenia DATE NULL,
  PRIMARY KEY(idPracownik)
)
END

IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Domek_letniskowy'))
BEGIN
  CREATE TABLE Domek_letniskowy (
  id INTEGER NOT NULL IDENTITY,
  nazwa VARCHAR(30) NOT NULL,
  cena_za_noc FLOAT NOT NULL,
  data_budowy DATE NULL,
  ilosc_miejsc INTEGER NULL,
  PRIMARY KEY(id)
);
END

IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Klient'))
BEGIN
  CREATE TABLE Klient (
  idKlient INTEGER NOT NULL IDENTITY,
  imie VARCHAR(30) NOT NULL,
  nazwisko VARCHAR(30) NOT NULL,
  PESEL CHAR(11) NOT NULL,
  data_urodzenia DATE NULL,
  kary FLOAT NULL,
  PRIMARY KEY(idKlient)
);
END

IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Sprzet'))
BEGIN
  CREATE TABLE Sprzet (
  idSprzet INTEGER NOT NULL IDENTITY,
  nazwa VARCHAR(40) NOT NULL,
  cena_za_godzine FLOAT NOT NULL,
  data_nastepnego_przegladu DATE NOT NULL,
  lokalizacja VARCHAR(80) NULL,
  PRIMARY KEY(idSprzet),
);
END

IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Wypozyczenie_domkow'))
BEGIN
  CREATE TABLE Wypozyczenie_domkow (
  idWypozyczenie_domkow INTEGER NOT NULL IDENTITY,
  Pracownik_idPracownik INTEGER NOT NULL,
  Klient_idKlient INTEGER NOT NULL,
  laczna_cena FLOAT NOT NULL,
  data_zlozenia_zamowienia DATE NOT NULL,
  uwagi VARCHAR(300) NULL,
  PRIMARY KEY(idWypozyczenie_domkow),
  FOREIGN KEY(Pracownik_idPracownik)
    REFERENCES Pracownik(idPracownik)
      ON DELETE NO ACTION
      ON UPDATE CASCADE,
  FOREIGN KEY(Klient_idKlient)
    REFERENCES Klient(idKlient)
      ON DELETE NO ACTION
      ON UPDATE CASCADE,
);
END

IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Rachunek_faktura'))
BEGIN
  CREATE TABLE Rachunek_faktura (
  Wypozyczenie_domkow_idWypozyczenie_domkow INTEGER NOT NULL,
  cena_netto FLOAT NOT NULL,
  cena_brutto FLOAT NOT NULL,
  data_wystawienia DATE NOT NULL,
  data_wplaty DATE NOT NULL,
  czy_oplacone BIT NOT NULL,
  rabat FLOAT NULL,
  PRIMARY KEY(Wypozyczenie_domkow_idWypozyczenie_domkow),
  FOREIGN KEY(Wypozyczenie_domkow_idWypozyczenie_domkow)
    REFERENCES Wypozyczenie_domkow(idWypozyczenie_domkow)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);
END

IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Zarezerwowanie_sprzetu'))
BEGIN
  CREATE TABLE Zarezerwowanie_sprzetu (
  idZarezerwowanie_sprzetu INTEGER NOT NULL IDENTITY,
  Klient_idKlient INTEGER NOT NULL,
  Pracownik_idPracownik INTEGER NOT NULL,
  Sprzet_idSprzet INTEGER NOT NULL,
  uwagi VARCHAR(30) NOT NULL,
  data_od DATETIME NOT NULL,
  data_do DATETIME NOT NULL,
  cena FLOAT NOT NULL,
  PRIMARY KEY(idZarezerwowanie_sprzetu),
  FOREIGN KEY(Pracownik_idPracownik)
    REFERENCES Pracownik(idPracownik)
      ON DELETE NO ACTION
      ON UPDATE CASCADE,
  FOREIGN KEY(Klient_idKlient)
    REFERENCES Klient(idKlient)
      ON DELETE NO ACTION		
      ON UPDATE NO ACTION,
	FOREIGN KEY(Sprzet_idSprzet)
		REFERENCES Sprzet(idSprzet)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
);
END

IF (NOT EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'dbo' 
                 AND  TABLE_NAME = 'Wypozyczenie_domku'))
BEGIN
  CREATE TABLE Wypozyczenie_domku (

  Wypozyczenie_domkow_idWypozyczenie_domkow INTEGER NOT NULL,
  Domek_letniskowy_id INTEGER NOT NULL,
  data__od DATE NULL,
  data__do DATE NULL,
  cena FLOAT NULL,
  FOREIGN KEY(Wypozyczenie_domkow_idWypozyczenie_domkow)
    REFERENCES Wypozyczenie_domkow(idWypozyczenie_domkow)
      ON DELETE NO ACTION
      ON UPDATE CASCADE,
  FOREIGN KEY(Domek_letniskowy_id)
    REFERENCES Domek_letniskowy(id)
      ON DELETE NO ACTION
      ON UPDATE CASCADE
);
END
