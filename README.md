# JavaProject
## Über uns
### Teammitglieder
Anton Bespalov, Michael Hopp, Tom Käppler
...
## HowTo

# Requirements Engineering: Online Shop "WatchMyWatch"
## [UML Klassendiagramm](https://www.lucidchart.com/invitations/accept/8876c528-b94f-460d-b4bf-f28249aa68e6) #1
[Beispieldiagramm](https://www.uml-diagrams.org/examples/online-shopping-domain-uml-diagram-example.html "Vorlage")
### Produkte
Armbanduhren verschiedener Preisklassen

### Stakeholder/Akteure:
Käufer, Shop-Betreiber(Geschäftsführer), Personal(...), Externe1, Externe2, Externe3, ...

### Events
Login, Registrierung, "Kauf", Warenkorb füllen, Produkte filtern, ... 

### Klassen
Product, Order, User, Vendor, Preis, Warenkorb, ...

## Anforderungsbeschreibung(Grob)
Es soll ein Online Shop entwickelt werden, über den Armbanduhren verschiedener Preisklassen von Herstellern 
auf einer Website dargestellt und vertrieben werden. Käufer müssen sich zum Bestellen einen Account in unserer 
Accountverwaltung anlegen, in dem deren Stammdaten erfasst werden. Diesen Account können sie bearbeiten und 
ggfs. löschen.Das System erstellt eine Bestellhistorie der Produkte und Käufer für die Verkaufsanalyse(z.B. 
Topseller, Käuferprofil, Umsatz). Beim Löschen des Käuferaccounts bleibt die Bestellhistorie erhalten und die 
personenbezogenen Käuferdaten werden verschleiert (Empfindliche Daten durch dafür vorgesehene Standardwerte 
ersetzen). In der Lagerverwaltung/dem Warenhaus, solldas Inventar, sowie Herstellerlieferungen und -Daten 
verwaltet und nötige Informationen für den Versand der Waren an die Käufer erfasst werden. Die Stammdaten des 
Personals sollen in der Personalverwaltung beschrieben werden(Wer arbeitet wo?).


## Teilsysteme
1. Shop: Darstellung der Produkte, Bestellungen: Wer hat was, wann gekauft? Wunsch:Merkzettel/Beobachtungsliste.

2. Accountverwaltung: Käuferdaten, Registrierung, Login.

3. Lagerverwaltung: Inventar+"Einkaufsliste", Herstellerdaten, Versand: Was, Wann, an Wen? 

4. Personalverwaltung Stammdaten von Admins, Contentmanager, Lagerarbeiter, Analysten und Support(Hotline).

## Abgrenzung(Das System soll nicht:)
1. Rechnungswesen: Das System soll keine Lohnzahlungen an Person, sowie Rechnungen und deren Abwicklung von Kunden- oder
Herstellerkäufen verwalten. Dies übernimmt ein externer Dienstleister.

2. Zahlung: Über externen Dienstleiste PayPal oder SofortÜberweisung: Am Ende des Bestell-
vorgangs, wird der Käufer dorthin weitergeleitet, Shop gibt Käufer- und Bestelldaten an 
Paypal o.Ä. weiter und erhält eine Status-Rückmeldung.

3. Lieferung: Über externe Lieferdienste denen das System die benötigten Informationen
weiterleitet.

4. Arbeitszeiterfassungsystem: Informationen in Bezug auf Arbeits- und Urlaubszeiten des Personals werden von einem externen
Dienstleister verwaltet.


## Protokoll

### 05.11.
- Login: Passwort soll mit Hashwerten kodiert werden.
- Gäste sollen auch Einkaufswagen haben.
- Uhren bestehen aus mehreren Teilen: Armband, Gehäuse und Ziffernblatt, die als eigene Klassen modelliert werden sollen. Vererbung sinnvoll?
- Klassendiagramme sind schwer von ER-Modellen abzugrenzen
- Daten nur auf Datenbank-Ebene oder auch direkt in Java?
- Java Klassen würden Daten aus Datenbank holen und diese dann nur verarbeiten?!
- Preisklasse 100-50.000€






