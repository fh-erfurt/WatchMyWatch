# JavaProject

[![Build Status](https://github.com/fh-erfurt/WatchMyWatch/workflows/WatchMyWatch/badge.svg)](https://github.com/fh-erfurt/WatchMyWatch/actions)


## Über uns
### Teammitglieder
Anton Bespalov, Michael Hopp, Tom Käppler
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

3. Lagerverwaltung: Inventar, Herstellerdaten, Versand: Was, Wann, an Wen? 

## Abgrenzung(Das System soll nicht:)
1. Rechnungswesen: Das System soll keine Lohnzahlungen an Person, sowie Rechnungen und deren Abwicklung von Kunden- oder
Herstellerkäufen verwalten. Dies übernimmt ein externer Dienstleister.

2. Zahlung: Über externen Dienstleiste PayPal oder SofortÜberweisung: Am Ende des Bestell-
vorgangs, wird der Käufer dorthin weitergeleitet, Shop gibt Käufer- und Bestelldaten an 
Paypal o.Ä. weiter und erhält eine Status-Rückmeldung.

3. Lieferung: Über externe Lieferdienste denen das System die benötigten Informationen
weiterleitet.

4. Personalverwaltung: Stammdaten von Admins, Contentmanager, Lagerarbeiter, Analysten und Support(Hotline), Arbeitszeiterfassungsystem: Informationen in Bezug auf Arbeits- und Urlaubszeiten des Personals werden von einem externen Dienstleister verwaltet.


## Protokoll

### 05.11.
- Gäste sollen auch Einkaufswagen haben.
- Uhren bestehen aus mehreren Teilen: Armband, Gehäuse und Ziffernblatt, die als eigene Klassen modelliert werden sollen. Vererbung sinnvoll? !Ja, ist Sinnvoll
- Klassendiagramme sind schwer von ER-Modellen abzugrenzen
- Daten nur auf Datenbank-Ebene oder auch direkt in Java? !In Java
- Java Klassen würden Daten aus Datenbank holen und diese dann nur verarbeiten? !Java-Programm alleine
- Preisklasse der Uhren: 100€ bis 50.000€

### 12.11.
 - Klasse Manufacturer, Watchpart, Address hinzugefügt
 - WatchPart Attribut ManufacturerPartID hinzugefüggt, damit man mit ihr und dem Namen Einzelteile nachbestellen kann
 - Uhrenwerk und Gehäuse vielleicht nur zusammen verkaufen?
 - Uhren zusammenbauen kostet Geld, bei einem Preis von unter 2000 Euro kostet das Zusammenbauen 10% vom Uhrenpreis, über 2000 Euro kostet das Zusammenbauen pauschal 200 Euro
 - Phone wird einfach ein String sein und keine Klasse mehr
 - UML-Klassendiagramm verändert
 - http://www.appsdeveloperblog.com/encrypt-user-password-example-java/ für Login zum verschlüsseln des Passworts
 
 ### 19.11.
 - Für Konfigurator sollen noch extra Uhrenkomponenten aufgenommen werden: Ziffernblatt, Zeiger, ... Erweiterbares Modell.
 - Rahmenklasse Shop, der Produkte(Watches und Watchparts), Adressen, Bestellungen und Accounts beinhält.
 - Welchen Container für Watchparts in Shop? Multimap? Brauchen Typunterscheidungen der Teile. [Arraylist Multimap?](https://github.com/google/guava/wiki/NewCollectionTypesExplained)
 - Orders in Account als List zu speichern.
 - Methoden deklarieren: Bei keiner Klasse darf es ID-Setter-Methoden geben -> Werden im Konstruktor gesetzt.
 - Enums OrderStatus und ShippingStatus zu ergänzen?
 - Lieferung abgrenzen: Höchstens Lieferstatus abfragen(Post API) oder selber Fälle erfinden (Random Wartezeit in Sekunden zur         Andeutung).
 - Shopdaten(Bestellungen, Accounts, usw) per JSON in Textdateien speichern? Anschlaulichkeit, Robustheit, ... Notwendig?
 - Wo sind Infos über den Shop wie zB Inhaberinfo, Name des Shops, usw zu speichern?
 - Wir nutzen Github Desktop als Brücke zwischen Versionskontrolle und IntelliJ.
 
 ### 25.11.
 - Gäste sollen eine ShoppingCard kriegen, jedoch besteht das Problem, dass nicht angemeldete Gäste keine ShoppingCard kriegen können. 
 - Customer erbt von Person
 - Idee: Gäste ohne Account kriegen keine ShoppingCard
 - ShoppingCardID bei ShoppingCrad wird rausgenommen
 
 #### Zwischenpräsentation:
 - Zeigen wir Code bei der Zwischenpräsentation?
 - Geschäftsregeln präsentieren die beschlossen wurden.
 - Was geschieht als nächstes?
 - Jeder kriegt Klassen zu denen er sich Methoden ausdenkt.
 - Methoden in Code schreiben, danach UML-Klassendiagramm selbst erstellen lassen.
 ## Lessons Learned
 - Umstellungen auf neue Systeme (Git) bringen Unischerheit und Verzögerungen.
 - Wöchentliche Verständigung dringend aufrechthalten, sonst langsamerer Gesamt-Fortschritt und höherer Aufwand, um aktuellen Stand zu formulieren. -> Dranbleiben, solange man motiviert ist!
 - Aufgabenteilung ist gut aber wie soll mit Versäumnissen umgegangen werden?
 - Zwischenziele erreicht aber wir hätten mehr schaffen können -> Zumindest hatten wir die Ressourcen dafür... Heiße Phase kommt erst noch, da käme gelegen, wenn Last durch Vorarbeit abgenommen würde.
 - Wir haben Test-Driven Design vernachlässigt -> Eher Sequentielles Verfahren genutzt: Aktuell in Implementierungsphase mit gelegentlicher Rückkopplung zu bisher unbeachteteten Anforderungen und unsauberen Entwurf.
 - Abgrenzung zu Datenbanken schwieriger als Gedacht: Mangelnde Erfahrung außerhalb des DB-Kontexts. (Klassendiagramm sah anfangs wie ER-Modell aus) -> Sich der eigentlichen Aufgabe "Serverseitige Anwendung" besinnen: Zur Laufzeit, also keine DB.
 

### 26.11.
- Die Adressen speichern wir als Map
- UML paar Namenänderungen
- Enum braceletconnection/casingconnection
- ID Autoincrement, mit ausnahmen(Account)
- Watchpart wird zu einer Abstraktenklasse
- Shop-Klasse aufteilen? KLasse wird sonst zu groß -> unübersichtlich
 
 
 
