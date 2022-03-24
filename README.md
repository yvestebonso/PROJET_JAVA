# Projet_Java
Application de gestion de location de véhicules
Ici il était question de concevoir une application permettant à des clients d'effecteur des reservations avec des contraintes biens définies.
Logiciel de développement utilisé:Eclipse et Intellij idea
Framework:Spring
Test:JUNIT

I-princiales fonctionnalités réalisées:



A-clients

Un client est carractérisé par son nom,son prénom,son email et sa date de naissance

Sur l'interface de notre application, on peut :
-   Créer un Client
-   Editer les informations sur un client
-   Lister tous les Client
-   Rechercher un client
-   Supprimer un Client
-   compter le nombre de clients

B- Véhicule

Un véhiule est caractérisé par sa marque,son modèle et son nombre de places.

Sur l'interface de notre application, on peut :

-   Créer un véhicule
-   Editer les informations sur un véhivule
-   Lister tous les véhicule
-   Rechercher un véhicule
-   Supprimer un véhécule
-   compter le nombre de véhicule

C-Reservation
pour effectuer une réservation, on a besoin du nom et du prénom du client , de la marque et du modèle du véhicule , de la date de début et de fin de la réservation

Sur l'interface graphique de notre application , on peut :
-   Créer une réservation
-   Editer les informations sur la réservation d'un client donné.
-   Lister toutes les réseravtions
-   Lister toutes les réseravtions par raport à un client donné
-   Rechercher une réservation par rapport à un Client donné
-   Rechercher une réservation par rapport à un véhicule donné
-   supprimer une réservation
-   compter le nombre de reservation



II-MISE EN PLACE DES TEST.

Ici il était question de mettre en place des tests , nous avons éffectué 2 tests unitaire et 2 test mocks notamment sur la client et sur le véhicule.

III- AJOUT DES CONTRAINTES

Ici il était question de mettre en place des contraintes afin par exemple de limiter un certain accés à une certaine catégorie de clients ou encore de valider que des informations que si les contraintes sont respectées

Les contraintes réalisées sont les suivantes 

- un client n'ayant pas 18ans ne peut pas être créé
- un client ayant une adresse mail déjà prise ne peut pas être créé
- le nom et le prénom d'un client doivent faire au moins 3 caractères
- une voiture doit avoir un modèle et un constructeur, son nombre de place doit   être compris entre 2 et 9
- si un client ou un véhicule est supprimé, alors il faut supprimer les 
- réservations associées
une voiture ne peux pas être réservé 2 fois le même jour



IV- DIFFICULTES RENCONTREES

- Difficulté parfois dans les manipulations des types date
- Difficultés lors de la réalisation de certaines contraintes
- Bug d'eclipse


