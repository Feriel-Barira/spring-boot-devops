Feature: Gestion des utilisateurs

  Scenario: Sauvegarde d'un nouvel utilisateur
    Given un utilisateur avec le nom "Feriel" et l'email "feriel@gmail.com"
    When je sauvegarde cet utilisateur
    Then l'utilisateur est enregistré avec un identifiant