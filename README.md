# TP sur la qualité logicielle

Exercices de Java, module 350 pour l'IPI. Il est nécessaire de forker ce repository pour pouvoir faire tout le TP !! Après chaque question, pusher vos modifications sur votre repository.

## Pré-requis

- Installer IntelliJ Ultimate en utilisant votre adresse IPI sur Jetbrains Student https://www.jetbrains.com/student/
ou un autre IDE si vous avez l'habitude (Eclipse)
- Si vous n'êtes pas familié avec Git, je vous recommande ce site : https://learngitbranching.js.org/ (faire au moins la première leçon du niveau 1)
Via Microsoft Imagine, activer votre crédit étudiant Azure https://imagine.microsoft.com/fr-fr (ou via le mail reçu en début d'année, onthehub https://onthehub.com/)
- S'inscrire également au programme AWS Educate toujours avec votre adresse IPI (https://aws.amazon.com/fr/education/awseducate/).

## Introduction

Questions à se poser : 
- Que représente pour vous la qualité logicielle ?
- Quels éléments faut-il pour avoir un logiciel de qualité ?
- Dans un projet, qui est responsable de la qualité ?
- Quand doit-on se préoccuper de la qualité dans la vie d'un projet ?

Faire une recherche sur la qualité logicielle sur le web...
Répondre de nouveau aux questions. Qu'est-ce qui a changé ?

## Intégration continue

   - Rajouter la configuration nécessaire pour Travis dans le projet.
   - Vous connecter à Travis https://travis-ci.org avec votre compte Github.
   - Configurer le projet et vérifier que le premier build se passe correctement. Après chaque exercice, vérifier que le build passe toujours...
 
## Evaluation de la qualité

   - Connectez-vous à SonarQube https://about.sonarcloud.io/ avec votre compte Github
   - Ajouter votre projet dans Sonar
   - Modifier votre configuration Travis pour lancer une analyse après chaque build
   - Vérifier que tout est ok
   - Analyser le premier rapport de Sonar

## Tests unitaires

### Tests unitaires classiques

Créer la classe permettant de tester la méthode `getNombreAnneeAnciennete` de la classe `Employe` et mettre en place les tests unitaires nécessaires pour tester le plus exhaustivement possible cette méthode. Bien penser à tous les cas possibles, notamment les cas aux limites. Ne pas hésiter à corriger le code de la méthode initiale si besoin.

### Tests paramétrés

Créer une méthode de test paramétré permettant de tester le plus exhaustivement possible la méthode `getPrimeAnnuelle` de la classe `Employe` et corriger les éventuels problème de cette méthode.

### Tests mockés

Créer la classe de test et les méthodes permettant de tester la méthode `embaucheEmploye` de `EmployeService` sans la dépendance à la BDD.

## Tests d'intégration

### Tests de repository

Créer la classe de test et les méthodes permettant de tester la méthode `findLastMatricule` de `EmployeRepository`.

### Tests de service intégrés

Tester de façon intégrée un cas nominal de la méthode `embaucheEmploye` de la classe `EmployeService`.

## Tests d'acceptation

- Installer Gauge depuis https://gauge.org/. La méthode d'installation recommandée est via npm. Il faut donc installer NodeJS. D'autres méthodes sont possibles cependant. 
- Ajouter le chemin de l'exécutable Gauge dans la variable d'environnement PATH. Vous pouvez utiliser la commande `where gauge` dans une invite de commande Windows, ou `which gauge` dans un terminal Linux.
- À l'aide d'un terminal, vous positionner à la racine de votre projet Java et initialiser (à l'aide de la documentation) un nouveau projet Gauge Java. Déplacer le dossier `specs` dans le dossier `src/test/resources`.
- Un projet d'exemple de Gauge avec Spring se trouve à cette adresse : https://github.com/getgauge-examples/ioc-spring
- Récupérer les classes `RegisterIOC` et `SpringGaugeTestApp` et les intégrer dans votre projet. Vous inspirer de la classe `PaymentService` pour ajouter les Step nécessaires pour écrirer un test d'acceptation validant la fonctionnalité d'embauche d'un employé.

## Maintenabilité

- S'assurer de la lisibilité du code et du respect des conventions.
- Ajouter des `logger` aux endroits stratégiques du code en utilisant le bon niveau de log. Rediriger toutes les logs d'erreur dans un fichier `error.log` et tous vos logs dans un fichier `logs.log`. Ajouter la configuration de rotation tous les jours et faire en sorte que les fichiers ne puissent dépasser 10Mo.
- Vérifier et le cas échéant compléter la documentation du code, générer la JavaDoc avec maven.
- Ajouter à votre Github une documentation statique avec MkDocs.
- Ajouter des badges contenant les métriques principales de votre projet en haut de ce README à l'aide de l'API de Sonar : https://sonarcloud.io/web_api/api/project_badges

# Evaluation

Commencer par faire une branche `evaluation` à partir de votre branche `master` une fois le TP terminé. Travailler sur cette branche pour l'évaluation.

## Tests unitaires et TDD

- Tester de manière unitaire le plus exhaustivement possible la méthode `augmenterSalaire` d'`Employe` en essayant de faire du TDD. Décommenter la méthode dans `Employe` et écrire d'abord les tests entièrement (en réflechissant particulièrement aux cas limites) avant d'écrire la méthode. Pensez-vous que vous auriez écrit la méthode directement comme cela si vous n'aviez pas écrit les tests en premier ?
- Tester unitairement (en utilisant les tests paramétrés) la méthode `getNbRtt` d'`Employe`. Le nombre de RTT se calcule à partir de la formule suivante : **Nombre de jours dans l'année - Nombre de jours travaillés dans l'année en plein temps - Nombre de samedi et dimanche dans l'année - Nombre de jours fériés ne tombant pas le week-end - Nombre de congés payés**. Le tout au pro-rata du taux d'activité du salarié. **Attention**, des erreurs sont présentes dans cette méthode. Faites donc vos calculs avant et débugguer votre code pour trouver les erreurs. Aidez-vous de Sonar... Rendre cette méthode plus propre, documentée et lisible.
Infos : 
  - 2019 : l'année est non bissextile, a débuté un mardi et il y a 10 jours fériés ne tombant pas le week-end.
  - 2021 : l'année est non bissextile, a débuté un vendredi et il y a 7 jours fériés ne tombant pas le week-end.
  - 2022 : l'année est non bissextile, a débuté un samedi et il y a 7 jours fériés ne tombant pas le week-end.
  - 2032 : l'année est bissextile, a débuté un jeudi et il y a 7 jours fériés ne tombant pas le week-end.

- Tester sans dépendance à la BDD la méthode `calculPerformanceCommercial` d'`EmployeService`

## Tests d'intégration

- Tester de manière intégrée une cas nominal de la méthode précédente
- Tester de manière intégrée la méthode d'`EmployeRepository` `avgPerformanceWhereMatriculeStartsWith`
- BONUS Ecrire un test d'acceptation Gauge pour la fonctionnalité de calcul de performance d'un commercial.

## Autres

- S'assurer que votre code passe et qu'il n'y a aucun *code smells* ou *anomalies* ou *bugs* bloquants, critiques ou majeurs. Si c'est le cas, corriger le code fourni.
- S'assurer d'avoir 100% de couverture de code sur les méthodes testés dans l'évaluation. Vérifier la couverture de code avec mutation et à défaut d'atteindre 100%, essayer d'obtenir un bon niveau.

## Revue de code

En fin de TP, créer une Pull Request de votre branche `evaluation` vers `master` et mettez-vous d'accord avec un collègue pour qu'il fasse la revue de code. Faites les éventuelles modifications puis affectez-moi la PR.
