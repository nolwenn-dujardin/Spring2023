# TAA 2023-24

***

Développeurs (M2 IL) :
* DUJARDIN Nolwenn
* BOUGAUD Jean-Baptiste

***

## Modèle Objet

![Modele.png](img%2FModele.png)

***

## Le(s) TP précédent(s) :
* [TP1 et Début TP2](https://github.com/JB2907/TP_TAA)
* [TP2](https://github.com/nolwenn-dujardin/JaxRSOpenAPI)

***

### Pour démarrer l'application
* Partie 1 : Lancez SampleSimpleApplication.java
* Partie 2 : Lancez SampleAopApplication.java
* Partie 3 : Lancez une base données MySQL et créer une table nommée "taa_database" puis exécuter SampleDataJpaApplication.java

* Partie 1 - Capture d'écran<br/>
![part1.png](img%2Fpart1.png)
* Partie 2 - Capture d'écran<br/>
![part2.png](img%2Fpart2.png)

### Liste des requêtes possibles:

ProfessionalController :
* POST - /create-pro
* PUT - /update-pro (/update?id=256&email=bob@ok.fr&name=bob)

ClientController :
* POST - /create-client
* PUT - /update-client (/update?id=256&email=bob@ok.fr&name=bob)

UserController :
* POST : /create
* DELETE : /delete   (/delete?id=256)
* GET : /get-by-email/  (/get-by-email/bob@ok.fr)
* PUT : /update (/update?id=256&email=bob@ok.fr&name=bob)

RDVController :
* POST : /create-rdv
* GET : /rdv/   (/rdv/1)
* DELETE : /delete-rdv (/delete-rdv?id=3)
* PUT : /update-rdv/ (/update-rdv/1)