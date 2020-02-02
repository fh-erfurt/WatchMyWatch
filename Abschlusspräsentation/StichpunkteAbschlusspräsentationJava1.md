# Abschlusspräsentation Java 1 Projekt

1. Start (Michael)
   - Projektabschluss Java 1
   - Einblick **Was** wir **Wie** erreicht haben

2. Gliederung (Michael)
   - Allgemeines​ über uns vorweg
   - Zur Erinnerung nochmal unsere Projekt-Idee
   - Unsere Projektstruktur​ und grobe Aufgabenteilung
   - Unser Klassenmodell​ in Komplettansicht und Subsysteme
     - Accountverwaltung​
     - Bestellungsverwaltung​
     - Uhrenverwaltung​
   - Vorstellung unseres Validierungs Interface​
   - Beispiel eines "Integration Test​s"
   - Grundlagen für den Konfigurator​
   - Lessons Learned
  
3. Allgemeines (Michael)
   - Wer wir sind
   - Wo ihr unser Repo findet
   - Programme, mit denen wir gearbeitet haben

4. Idee (Michael)
    - Wo haben wir Angefangen
    - Armbanduhren Online-Shop
    - Besonderheit: Konfigurator

5. Projektstruktur (Tom)
6. Klassenmodell (Anton)
7. Accountverwaltung (Anton)
   - Account -> alle Daten zusammengefasst
   - Customer extends Person 
   - In ManagerAccount und ManagerCustomer sind jeweils Listen von Accounts und Customers
8. Bestellungsverwaltung (Michael)
   - Schwerpunkt die Klasse Bestellung:
     - Bestellungs- und Versandstatus, Versandkosten-Konstante sowie Datum+Zeit der Bestellung.
     - Darf keinen leeren Warenkorb enthalten -> Exception
   - Warenkorb: Was, Wie oft, zu welchem Preis bestellt wird
   - Zahlungsinformationen in Payment: Methode, Verwendungszweck o.Ä. und Datum der Bezahlung. Falls Date is set => Order is paid.

9. Uhrenverwaltung (Tom)
10. Validierungs Interface (Tom)
11. Grundlagen für Konfigurator (Tom)

12. Integration Test (Michael)
    - Keine Gottklasse "Shop", die die Subsysteme zusammenführt, sondern Integrations Tests.
    - Hier der Use Case "New User wants to buy a Watch" am einfachsten Fall, dem "Happy Path" erklärt.
      - Ausgangssituation
      - Account mit Stammdaten(Person, Address), leerem Einkaufwagen und keinen Bestellungen erstellen
      - Stöbern im Warenkatalog -> Eine Vordefinierte(, valide) Uhr gefunden
      - Uhr zum Warenkorb des Account hinzufügen
      - Zufrieden -> leitet Bestellvorgang ein
      - Erzeugt neue Bestellung für Account mit vorhandenem Warenkorb
      - Bestellung wartet auf Bezahlung, also dass PaymentDate gesetzt ist.
      - Sobald Bezahlt, ist die Bestellung vollständig und kann an den Lieferdienst übergeben werden.

13. Lessons Learned (Anton)
      - Test-Driven Design
      - Abgrenzung zur Datenbankenprogrammierung 
      - Kommunikation ist sehr wichtig
      - Intensiv Arbeiten
      - Häufiger an dem Projekt arbeiten
      - Aufgabenteilung
14. Ende (Anton)
