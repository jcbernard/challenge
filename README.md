Description de la solution
==========================

Framework
---------

La solution est basée sur le framework Spring. J'ai souhaité utilisé Spring car je ne l'avais jamais utilisé et aussi car j'avais assisté à une démo sur Spring Boot au JUG Montpellier l'an dernier. Spring permet de s'extraire de beaucoup de travail notament dans l'acces aux données et dans la publication de l'API REST.

J'utilise spring-boot-starter-data-jpa pour la persistence, spring-boot-starter-data-rest pour la publication de l'API, spring-boot-starter-security pour l'authentication et l'authorisation.

Composition
-----------

Le code s'articule autour de 4 fichiers :
- Item.java qui contient la description de l'entité représentant un item de la FAQ (question, réponse et tags).
- ItemRepository.java qui décrit à la fois la couche d'accès aux données et l'API REST. Ce n'est qu'une interface dont Spring va créer l'implémentation en fonction de règles de nommages des méthodes et des annotations (notamment query en JPQL) sur le méthodes.
- SecurityConfiguration.java qui va paramétrer les politiques de sécurité du service publié (droit d'accès par path, gestion des sessions).
- Application.java qui va bootstraper le tout grâce à spring-boot et notamment populer la base d'items pour les besoins du challenge.

Compilation & Déploiement
-------------------------

La compilation et packaging est opérée par Maven et produit un WAR (java 8) déployable dans tomcat (testé sur tomcat 8.5.31).

L'application contient 2 comptes utilisateurs pour les besoins du challenge :
- l'administrateur : admin / changeit
- un utilisateur lambda : user / changeit

Test
----

J'ai regroupé dans le projet Postman differentes requêtes relatives aux 3 user stories pour tester l'authentication et authorization ainsi que les données postées ou reçues.
L'intitulé des requêtes explicite la story testée (1, 1bis, 2, ...), les modalités du test (Admin do this, Guest do that, ...) ainsi que sont résultat attendu ([OK added item], [KO failed auth], ...).


Merci :)
