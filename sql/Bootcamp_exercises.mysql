-- 1.1
SELECT *
FROM Lid;

-- 1.2
SELECT Voornaam, Achternaam
FROM Lid;

-- 1.3
SELECT Voornaam, Geboortedatum
FROM Lid;

-- 1.4
SELECT *
FROM Locatie;

-- 2.1
SELECT Voornaam, tussenvoegsel, Achternaam, Woonplaats
FROM Lid
WHERE Woonplaats="Utrecht";

-- 2.2
SELECT Voornaam, tussenvoegsel, Achternaam, Woonplaats, Geslacht
FROM Lid
WHERE Woonplaats="Utrecht" AND Geslacht="Vrouw";

-- 2.3
SELECT Voornaam, tussenvoegsel, Achternaam, Woonplaats
FROM Lid
WHERE Woonplaats="Breukelen" OR Woonplaats="Soest";

-- 2.4
SELECT Voornaam, tussenvoegsel, Achternaam, Woonplaats, Geslacht
FROM Lid
WHERE (Woonplaats="Amstelveen" OR Woonplaats="Zeist") AND Geslacht="Man";

-- 2.5
SELECT Voornaam, tussenvoegsel, Achternaam
FROM Lid
WHERE tussenvoegsel IS NOT NULL;

-- 2.6
SELECT Voornaam, tussenvoegsel, Achternaam, (DATEDIFF(current_date, Geboortedatum)/365.2425) AS Leeftijd
FROM Lid
WHERE DATEDIFF(current_date, Geboortedatum)/365.2425 < 18;

-- 3.1
SELECT Woonplaats
FROM Lid
GROUP BY Woonplaats
ORDER BY Woonplaats;

-- 3.2
SELECT afstand
FROM UitslagIndividueel
GROUP BY afstand
ORDER BY afstand;

-- voorbeeld join
SELECT Lid.Voornaam, SoortLid.Naam
FROM Lid
JOIN SoortLid ON SoortLid.SoortLid = Lid.Soortlid;

-- 4.1
SELECT Lid.LidID, Lid.Voornaam, SoortLid.Naam
FROM Lid
JOIN SoortLid ON SoortLid.SoortLid = Lid.Soortlid;

-- 4.2
SELECT Lid.Voornaam, Functie.Functie
FROM Lid
JOIN FunctieLid ON FunctieLid.LidID = Lid.LidID
JOIN Functie ON Functie.FunctieID = FunctieLid.FunctieID;

-- 4.3
SELECT Wedstrijd.WedstrijdID, Locatie.Atletiekbaan, Locatie.Plaatsnaam, Wedstrijd.Datum
FROM Wedstrijd
JOIN Locatie ON Wedstrijd.LocatieID = Locatie.LocatieID
WHERE Locatie.Plaatsnaam = "Rotterdam";

-- 4.4 
SELECT UitslagIndividueel.WedstrijdID, Lid.Voornaam
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE UitslagIndividueel.WedstrijdID = 3;

-- 4.5
SELECT Locatie.Plaatsnaam, Lid.Voornaam
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
JOIN Wedstrijd ON UitslagIndividueel.WedstrijdID = Wedstrijd.WedstrijdID
JOIN Locatie ON Wedstrijd.LocatieID = Locatie.LocatieID
WHERE Wedstrijd.LocatieID = 2
GROUP BY Lid.Voornaam;

-- 5.1
SELECT Voornaam, Geboortedatum
FROM Lid
ORDER BY Geboortedatum desc
LIMIT 5;

-- 5.2
SELECT tijd
FROM UitslagIndividueel
WHERE afstand=100 AND tijd IS NOT NULL
ORDER BY tijd asc
LIMIT 10;

-- 5.3
SELECT Locatie.Atletiekbaan, Wedstrijd.Datum
FROM Wedstrijd
JOIN Locatie ON Wedstrijd.LocatieID = Locatie.LocatieID
Where Wedstrijd.Datum > CURRENT_DATE
ORDER BY Datum;

-- 5.4
SELECT Lid.Voornaam, UitslagIndividueel.afstand, UitslagIndividueel.tijd, Locatie.Atletiekbaan, Locatie.Plaatsnaam, Wedstrijd.Datum
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
JOIN Wedstrijd ON UitslagIndividueel.WedstrijdID = Wedstrijd.WedstrijdID
JOIN Locatie ON Wedstrijd.LocatieID = Locatie.LocatieID
WHERE Wedstrijd.LocatieID = 2 AND UitslagIndividueel.afstand=400
ORDER BY UitslagIndividueel.tijd 
LIMIT 10 OFFSET 3;

-- 6.1
SELECT Max(tijd) AS "Langzaamste Tijd"
FROM UitslagIndividueel
WHERE afstand=100;

-- 6.2
SELECT Lid.Voornaam, Lid.Achternaam, MIN(UitslagIndividueel.tijd) AS "PR"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE UitslagIndividueel.afstand = 400 AND Lid.LidID=19;

-- 6.3
SELECT Lid.Voornaam, Lid.Achternaam, AVG(UitslagIndividueel.tijd) AS "Gemiddelde tijd"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE UitslagIndividueel.afstand = 100 AND Lid.LidID=31;

-- 6.4
SELECT COUNT(Voornaam) AS "Aantal leden"
FROM Lid
WHERE Woonplaats="Utrecht" OR Woonplaats="Gouda" OR Woonplaats="Amstelveen";

-- 6.5
SELECT Woonplaats, COUNT(Woonplaats) AS "Aantal leden"
FROM Lid
WHERE Woonplaats="Utrecht" OR Woonplaats="Gouda" OR Woonplaats="Amstelveen"
GROUP BY Woonplaats;

-- 6.6
SELECT COUNT(DISTINCT(LocatieID)) AS "Aantal atletiekbanen"
FROM Wedstrijd
Where Datum < CURRENT_DATE;

-- 6.7
SELECT COUNT(DISTINCT(Locatie.Plaatsnaam)) AS "Aantal steden"
FROM Wedstrijd
JOIN Locatie ON Wedstrijd.LocatieID = Locatie.LocatieID
Where Datum < CURRENT_DATE;

-- 6.8
SELECT COUNT(LidID) AS "Aantal gelopen 100m's", SUM(tijd) AS "Totale tijd"
FROM UitslagIndividueel
WHERE Afstand = 100;

-- 6.9
SELECT Lid.Voornaam, Lid.Achternaam, UitslagIndividueel.tijd
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE Afstand = 400 AND tijd IS NOT null
ORDER BY UitslagIndividueel.tijd
LIMIT 5;

-- 6.10
SELECT Lid.Voornaam, COUNT(UitslagIndividueel.WedstrijdID) AS "Aantal Wedstrijden"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
JOIN Wedstrijd ON UitslagIndividueel.WedstrijdID = Wedstrijd.WedstrijdID
WHERE Wedstrijd.Datum < CURRENT_DATE
GROUP BY Lid.LidID
ORDER BY COUNT(Wedstrijd.WedstrijdID) DESC
LIMIT 5;

-- 7.1
SELECT Lid.Voornaam, COUNT(UitslagIndividueel.WedstrijdID) AS "Aantal Wedstrijden"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
JOIN Wedstrijd ON UitslagIndividueel.WedstrijdID = Wedstrijd.WedstrijdID
WHERE Wedstrijd.Datum < CURRENT_DATE
GROUP BY Lid.LidID
HAVING COUNT(UitslagIndividueel.WedstrijdID)>4
LIMIT 5;

-- 7.2 
SELECT Teamnaam, COUNT(TeamLid.LidID) AS "Aantal Leden" 
FROM Team
JOIN TeamLid ON Team.TeamID = TeamLid.TeamID
GROUP BY Teamnaam
HAVING COUNT(TeamLid.LidID)>5;

-- 7.3
SELECT tijd, COUNT(LidID) AS "Aantal keer gelopen"
FROM UitslagIndividueel
WHERE tijd IS NOT null
GROUP BY tijd
HAVING COUNT(LidID)>1
ORDER BY tijd;

-- 7.4
SELECT Lid.Voornaam, AVG(tijd) AS "Gemiddelde 100m tijd"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE tijd IS NOT NULL AND Afstand = 100
GROUP BY UitslagIndividueel.LidID
HAVING AVG(tijd) BETWEEN 10.50 AND 11.00
ORDER BY Lid.LidID;

-- 7.5
SELECT Lid.Voornaam, MIN(tijd) AS "Snelste 100m tijd"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE tijd IS NOT NULL AND Afstand = 100
GROUP BY UitslagIndividueel.LidID
HAVING MIN(tijd) < 10.50 
ORDER BY MIN(tijd);

-- 8.1
SELECT Team.TeamNaam, COUNT(TeamLid.LidID) AS "Aantal Leden" 
FROM Team
JOIN TeamLid ON Team.TeamID = TeamLid.TeamID
GROUP BY Team.TeamID
HAVING COUNT(TeamLid.LidID)=0;


-- 8.1 v2
SELECT Team.Teamnaam 
FROM Team
WHERE Team.TeamID NOT IN (SELECT TeamID FROM TeamLid);

-- 8.2 
SELECT Voornaam, Achternaam, StartLidmaatschap
FROM Lid
WHERE StartLidmaatschap < (SELECT StartLidmaatschap FROM Lid WHERE LidID=31);

-- 8.3
SELECT Voornaam, Achternaam, Huisnummer
FROM Lid
WHERE Huisnummer = (Select Huisnummer FROM Lid WHERE LIDID=2);

-- 8.4
SELECT Voornaam, Achternaam, Geboortedatum
FROM Lid
WHERE Geboortedatum < (SELECT Geboortedatum FROM Lid WHERE Voornaam="Vera" AND Achternaam = "Struin");

-- 8.5
SELECT Lid.Voornaam, Lid.Achternaam, MIN(tijd) AS "Snelste 100m tijd"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE tijd IS NOT NULL AND Afstand = 100
GROUP BY UitslagIndividueel.LidID
HAVING MIN(tijd) < (SELECT MIN(tijd) FROM UitslagIndividueel JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID WHERE Lid.Voornaam = "Ciara" AND Lid.Achternaam = "Twist")
ORDER BY MIN(tijd);

-- 8.6
SELECT Team.TeamNaam, COUNT(TeamLid.LidID) AS "Aantal Leden" 
FROM Team
JOIN TeamLid ON Team.TeamID = TeamLid.TeamID
GROUP BY Team.TeamID
HAVING COUNT(TeamLid.LidID)=(SELECT COUNT(TeamLid.LidID) FROM Team JOIN TeamLid ON Team.TeamID = TeamLid.TeamID WHERE Team.Teamnaam = "Hordenlopers" ORDER BY Team.TeamID);

-- 8.7
SELECT Voornaam, Leeftijdsklasse.NaamKlasse
FROM Lid, Leeftijdsklasse
WHERE (SELECT DATEDIFF(CURRENT_DATE, Lid.Geboortedatum)/365.25 AS 'Leeftijd'
	FROM Lid
	WHERE Lid.lidID=5)
	BETWEEN Leeftijdsklasse.MinimumLeeftijd AND Leeftijdsklasse.MaximumLeeftijd
	AND Lid.lidId=5;

-- 9.1
SELECT Voornaam, CONCAT (Straatnaam, " ", Huisnummer) AS "Adres"
FROM Lid
LIMIT 5;

-- 9.2
SELECT CONCAT (Voornaam, " ", IFNULL (CONCAT (Tussenvoegsel, " "), ""), Achternaam) AS "Volledige naam"
FROM Lid
LIMIT 5;

-- 9.3
SELECT Team.Teamnaam, GROUP_CONCAT(Lid.Voornaam)
FROM Team
LEFT JOIN TeamLid ON Team.TeamID = TeamLid.TeamID
Left JOIN Lid ON TeamLid.LidID = Lid.LidID
GROUP BY Team.TeamID
ORDER BY Team.TeamID;

-- 9.4
SELECT Lid.Voornaam, COUNT(Team.Teamnaam), GROUP_CONCAT(Team.Teamnaam)
FROM TeamLid
RIGHT JOIN Team ON  TeamLid.TeamID = Team.TeamID
RIGHT JOIN Lid ON TeamLid.LidID = Lid.lidID
GROUP BY Lid.LidID
LIMIT 5;

-- 9.5
SELECT COUNT(Distinct lidID) AS "Aantal leden in een team"
FROM TeamLid;

-- 9.6
SELECT CONCAT(Lid.Voornaam, " ", Lid.Achternaam) AS "Naam", COUNT(DISTINCT UitslagIndividueel.WedstrijdID) AS "Aantal Toernooien"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE Lid.LidID=19;

-- 9.7
SELECT Lid.Voornaam, Group_concat(distinct Locatie.Plaatsnaam)
FROM UitslagIndividueel
right JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
left JOIN Wedstrijd ON UitslagIndividueel.WedstrijdID = Wedstrijd.WedstrijdID
left JOIN Locatie ON Wedstrijd.LocatieID = Locatie.LocatieID
GROUP BY Lid.LidID
LIMIT 5;

-- 10.1
SELECT Voornaam
FROM Lid
WHERE Voornaam LIKE "T%";

-- 10.2
SELECT Voornaam
FROM Lid
WHERE Voornaam LIKE "K%" 
OR Voornaam LIKE "%k%"
OR Voornaam LIKE "%k";

-- 10.3
SELECT Voornaam, Emailadres
FROM Lid
WHERE Emailadres LIKE "%@qquest.nl";

-- 11.1
-- INSERT INTO Lid (Achternaam, Voorletters, Voornaam, Straatnaam, Huisnummer, Postcode, Woonplaats, Emailadres, Geboortedatum, Geslacht, SoortLid)
VALUES ("Beunders", "L. M.", "Lieke", "Loosdrechtsestraat", 18, "2574PM", "Den Haag", "liekebeunders@gmail.com", 17-06-1996, "Vrouw", "i");

-- 11.2
UPDATE Lid
SET Woonplaats="Yokohama"
WHERE Voornaam="Lieke";

-- 11.3
-- INSERT INTO Team(Teamnaam)
VALUES ("Lieke's Toppers");

-- 11.4
INSERT INTO TeamLid(TeamID, LidID)
VALUES 	(16, 69), 
			(16, 35);

-- 11.5
-- INSERT INTO TeamLid(teamID, LidID)
VALUES (16, 50);

-- 11.6
UPDATE Team
SET Teamnaam= "Poedelprijs"
WHERE TeamID = 16

-- 11.7
DELETE FROM Lid
WHERE LidID = 69;

-- 11.8
DELETE FROM TeamLid
WHERE LidID = 69;
DELETE FROM TeamLid
WHERE TeamID = 16;
DELETE FROM Team
WHERE TeamID = 16;

-- 11.9
DELETE FROM Lid
WHERE LidID = 69;

-- 12.1
SELECT CONCAT (Voornaam, " ", IFNULL (CONCAT (Tussenvoegsel, " "), ""), Achternaam) AS "Volledige naam"
FROM Lid
WHERE (Voornaam LIKE "A%" OR Achternaam LIKE "%A")
AND (CONCAT (Voornaam, " ", IFNULL (CONCAT (Tussenvoegsel, " "), ""), Achternaam)) LIKE "N%" 
OR (CONCAT (Voornaam, " ", IFNULL (CONCAT (Tussenvoegsel, " "), ""), Achternaam)) LIKE "%N%" 
OR (CONCAT (Voornaam, " ", IFNULL (CONCAT (Tussenvoegsel, " "), ""), Achternaam)) LIKE "%n%"
OR (CONCAT (Voornaam, " ", IFNULL (CONCAT (Tussenvoegsel, " "), ""), Achternaam)) LIKE "%n"
 
-- 12.2
SELECT Locatie.Atletiekbaan, Wedstrijd.Datum
FROM Wedstrijd
JOIN Locatie ON Wedstrijd.LocatieID = Locatie.LocatieID
where Datum < DATE_ADD(CURRENT_DATE, INTERVAL 6 MONTH) AND Datum > CURRENT_DATE;

-- 12.3
SELECT DISTINCT (Lid.Voornaam)
FROM UitslagIndividueel, Lid
WHERE Lid.LidID NOT IN (SELECT UitslagIndividueel.LidID FROM UitslagIndividueel);

-- 12.4
SELECT Voornaam, MAX(tijd)-MIN(tijd) AS "Verschil snelste & langzaamste tijd"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE afstand = 100 AND tijd IS NOT null
GROUP BY Lid.LidID
ORDER BY MAX(tijd)-MIN(tijd) desc
LIMIT 1;

-- 12.5
SELECT Lid.Voornaam, MIN(tijd) AS "Snelste 100m tijd"
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE afstand = 100
GROUP BY Lid.LidID
ORDER BY MIN(tijd)
LIMIT 4;

-- 12.6
SELECT Lid.Voornaam, tijd
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE Lid.Geslacht = "Man" 
AND tijd = (SELECT MIN(tijd) FROM UitslagIndividueel)
UNION 
SELECT Lid.Voornaam, tijd
FROM UitslagIndividueel
JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID
WHERE Lid.Geslacht = "Vrouw" 
AND tijd = (SELECT MIN(tijd) FROM UitslagIndividueel JOIN Lid ON UitslagIndividueel.LidID = Lid.LidID WHERE Lid.Geslacht = "Vrouw")
