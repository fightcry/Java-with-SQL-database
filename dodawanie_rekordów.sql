SET DATEFORMAT YMD

INSERT INTO pracownik(imie, nazwisko, PESEL, pensja, stanowisko, data_zatrudnienia, data_urodzenia)
VALUES ('Stefan', 'Czarnecki', '74030639158', '3000', 'konserwator', '2019/05/02','1974/03/06'),
('Roman', 'Dąbrowski', '66051410353', 4500, 'kucharz', '2019/11/01','1966/05/14'),
('Aneta', 'Kowalska', '78120205539', 3300, 'recepcjonista', '2020/01/30','1978/12/02')

INSERT INTO klient(imie, nazwisko, PESEL, data_urodzenia, kary)
VALUES ('Maciej', 'Kraszewski', '95072371844', '1995/07/23', 0.0),
('Zenon', 'Sobieski', '60111684120', '1960/11/26', 0.0),
('Karolina', 'Piech', '95102389391', '1995/10/23', 250.44)

INSERT INTO Domek_letniskowy(nazwa, cena_za_noc, data_budowy, ilosc_miejsc)
VALUES ('Domek mały', 250, '1990/10/01', 3),
('Domek średni', 450, '2012/05/01', 5),
('Domek duży', 500, '1990/10/01', 8)

INSERT INTO Sprzet(nazwa, cena_za_godzine, data_nastepnego_przegladu, lokalizacja)
VALUES ('Rakiety tenisowe', 20, '2021/01/01', 'Magazyn'),
('Paletki pingpongowe', 5, '2021/01/01', 'Magazyn'),
('Piłka', 5, '2020/05/31', 'Magazyn')

INSERT INTO Zarezerwowanie_sprzetu(Klient_idKlient, Pracownik_idPracownik, Sprzet_idSprzet, uwagi, data_od, data_do, cena)
VALUES(1, 1, 3, '', '2020/05/21', '2020/05/22', 30),
(2, 3, 1, '', '2020/05/20', '2020/05/23', 20),
(2, 3, 1, '', '2020/05/23', '2020/05/25', 20)

INSERT INTO Wypozyczenie_domkow(Pracownik_idPracownik, Klient_idKlient, laczna_cena, data_zlozenia_zamowienia, uwagi)
VALUES(3, 1, 900, '2020/05/21',''),
(3, 1, 450, '2020/05/23',''),
(3, 3, 500, '2020/05/20', 'brak')

INSERT INTO Rachunek_faktura(Wypozyczenie_domkow_idWypozyczenie_domkow, cena_netto, cena_brutto, data_wystawienia, data_wplaty, czy_oplacone, rabat)
VALUES(1, 900, 1107, '2020/05/25', '2020/05/25', 1, 0),
(2, 450, 553.5, '2020/05/27', '2020/05/30', 1, 0),
(3, 500, 615, '2020/05/27', '2020/05/27', 1, 0)

INSERT INTO Wypozyczenie_domku(Wypozyczenie_domkow_idWypozyczenie_domkow, Domek_letniskowy_id, data__od, data__do, cena)
VALUES(1, 2, '2020/05/21', '2020/05/23', 900),
(2, 2, '2020/05/23', '2020/05/24', 450),
(3, 3, '2020/05/20', '2020/05/21', 500)


