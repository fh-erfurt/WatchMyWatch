# JavaProject [![Build Status](https://github.com/fh-erfurt/WatchMyWatch/workflows/WatchMyWatch/badge.svg)](https://github.com/fh-erfurt/WatchMyWatch/actions)
Von Anton Bespalov, Michael Hopp, Tom Käppler

## HowTo
Öffnen Sie die pom.xml in IntelliJ

## Projektbeschreibung
WatchMyWatch ist ein Armbanduhren Online-Shop, der registrierten Kunden die Möglichkeit bietet, eine vorgebaute Uhr zu erwerben oder selbst eine Konfiguration aus den angebotenen Uhrenteilen zusammenzustellen.

Erläuterung am Use Case "New User wants to buy a Watch": ![EPK](EPK WatchMyWatch.png?raw=true)
### Klassendiamgramm
- Aktuell: Version 2 ![UML](UML.png?raw=true)
- Version 1: [UML Klassendiagramm WatchMyWatch](https://www.lucidchart.com/invitations/accept/8876c528-b94f-460d-b4bf-f28249aa68e6) inspiriert durch [Beispieldiagramm](https://www.uml-diagrams.org/examples/online-shopping-domain-uml-diagram-example.html "Vorlage")

### Stakeholder/Akteure:
| Name/Bezeichnung              | Beschreibung  |
| -------------                 |:-------------:        |
| Kunden(Customer)              | Registriert sich im System und bestellt Uhren |
| Hersteller(Manufacturer)                    | Produzent von Uhrenteilen |
| Konfigurations-Personal       | Baut Uhren zusammen  |
| Lieferdienst                  | Paketversand des Shops |
| Zahlungsdienstleister         | z.B. PayPal |
| Geschäftsführer               | Rechtlicher Eigentümer von WatchMyWatch |
| Admins/Webmaster              | Entwicklung und Wartung des Systems |
| Contentmanager                | Pflegt neue Uhren und Einzelteile in das System ein |
| Analysten                     | Wertet Verkaufsstatistiken und Nutzungsverhalten des Systems aus |
| Support(Hotline)              | Erster Ansprechpartner bei technischen Problemen, Fragen oder Anregungen zum System  |

### Anforderungsbeschreibung(Grob)
Es soll ein Online Shop entwickelt werden, über den Armbanduhren verschiedener Preisklassen auf einer Website dargestellt und vertrieben werden. Die Uhren sollen aus einem Vorrat von Komponenten konfigurierbar sein, wobei das System die Kompatibilität der Einzelteile berücksichten und dem Kunden mit Vorschlägen und Hinweisen Hilfestellung leisten soll.
Kunden müssen sich zum Bestellen einen Account in unserer Accountverwaltung anlegen, in dem ihre Stammdaten erfasst werden. Diesen Account können sie bearbeiten und ggfs. löschen. Für die Bezahlung werden sie zur Addresse des ausgewählten Zahlungsdienstleisters weitergeleitet.

#### Wunschkriterien
- Beim Löschen des Kundenaccounts bleibt die Bestellhistorie erhalten und die 
personenbezogenen Käuferdaten werden verschleiert (Empfindliche Daten durch dafür vorgesehene Standardwerte 
ersetzen).
- Das System wertet die Bestellhistorie der Produkte und Kunden aus (z.B. Topseller, Käuferprofil, Umsatz).
- Für Konfigurator sollen mehr Uhrenkomponenten aufgenommen werden, um Individualisierung noch weiter zu verfeinern: Ziffernblatt, Zeiger, Verschluss, ...

### Teilsysteme
1. Uhrenverwaltung: Uhren und Uhrenteile sowie Konfigurationslogik, Herstellerdaten.
2. Accountverwaltung: Account- und Kundendaten, Registrierung, Login, Bestellhistorie.
3. Bestellungsverwaltung: Bestellungsdaten, Warenkörbe und Zahlungs-, Versandinformationen.

Ab Modul Java 2 zusätzlich Konfigurator.

### Abgrenzung(Das System soll nicht beinhalten:)
1. Rechnungswesen: Das System soll keine Lohnzahlungen an Personal oder Rechnungen und deren Abwicklung von Kunden- oder
Herstellerkäufen verwalten. Dies übernimmt ein externer Dienstleister.

2. Zahlungsabwicklung: Stattdessen über externen Zahlungsdienstleister PayPal oder SofortÜberweisung: Am Ende des Bestellvorgangs, wird der Käufer dorthin weitergeleitet, Shop gibt nötige Käufer- und Bestelldaten an 
Paypal o.Ä. weiter und erhält eine Status-Rückmeldung.

3. Lieferung: Stattdessen über externe Lieferdienste, denen das System nur die benötigten Informationen
weiterleitet. (Post API)

4. Personalverwaltung: Stammdaten von Admins, Contentmanagern, Lagerarbeitern, Analysten und Support(Hotline) sowie die Arbeitszeiterfassung (Informationen in Bezug auf Arbeits- und Urlaubszeiten des Personals) werden von einem externen Dienstleister verwaltet.

### Geschäftsregeln, Festlegungen, Besonderheiten
- Richtwert für Preisklasse der Uhren: 100€ bis 50.000€
- Uhren zusammenbauen kostet eine Gebühr: Bei einem Preis von unter 2000 Euro kostet das Zusammenbauen 10% vom Uhrenpreis, ab 2000 Euro dann pauschal 200 Euro.
- Gäste bekommen vorerst keinen Einkaufswagen.
- Ein Kunde kann seine Bestellungen vorerst nur nach dem "First Come First Serve" Prinzip bezahlen.
- Login-Funktion wird erst implementiert, wenn nötig.

## Über uns
#### Arbeits-/Aufgabenteilung
- **Anton Bespalov:**
  - Accountverwaltung
  - Adressverwaltung
  - ReadMe

- **Michael Hopp:**
  - Bestellungsverwaltung
  - TestShop
  - ReadMe
  
- **Tom Käppler:**
  - Uhrenverwaltung
  - Validator
  - ReadMe
  - Projektstruktur
  
### Verwendete Technologie
    - IntelliJ Java 11
    - JUnit5.4, Maven, JavaDoc
    - Versionskontrollsystem: Git
    - Github Desktop als Brücke zwischen Versionskontrolle und Entwicklungsumgebung.
    - Kommunikation: WhatsApp und Discord

### Lessons Learned
- Umstellungen auf neue Systeme (Git) bringen Unischerheit und Verzögerungen.
- Wöchentliche Verständigung dringend aufrechthalten, sonst langsamerer Gesamt-Fortschritt und höherer Aufwand, um aktuellen Stand zu     formulieren. -> Dranbleiben, solange man motiviert ist!
- Aufgabenteilung ist gut, aber wie soll mit Versäumnissen umgegangen werden?
- Zwischenziele erreicht, aber wir hätten mehr schaffen können -> Zumindest hatten wir die Ressourcen dafür... Heiße Phase kommt erst       noch, da käme es gelegen, wenn Last durch Vorarbeit abgenommen würde.
- Wir haben Test-Driven Design zu Beginn vernachlässigt, aber ab Implementierung dann prominent Verwendet.
- Abgrenzung zu Datenbanken schwieriger als gedacht: Mangelnde Erfahrung außerhalb des DB-Kontexts. (Klassendiagramm sah anfangs wie ER-   Modell aus) -> Sich der eigentlichen Aufgabe "Serverseitige Anwendung" besinnen: Zur Laufzeit, also keine DB.
