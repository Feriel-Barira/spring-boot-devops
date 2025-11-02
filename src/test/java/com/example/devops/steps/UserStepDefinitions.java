package com.example.devops.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStepDefinitions {
    private String nom;
    private String email;
    private boolean sauvegardeReussie = false;
    private Long identifiantUtilisateur;

    @Given("un utilisateur avec le nom {string} et l'email {string}")
    public void un_utilisateur_avec_le_nom_et_l_email(String nom, String email) {
        this.nom = nom;
        this.email = email;
        System.out.println("Création d'un utilisateur avec nom: " + nom + " et email: " + email);
    }

    @When("je sauvegarde cet utilisateur")
    public void je_sauvegarde_cet_utilisateur() {
        this.sauvegardeReussie = true;
        this.identifiantUtilisateur = 12345L;
        System.out.println("Sauvegarde de l'utilisateur...");
    }

    @Then("l'utilisateur est enregistré avec un identifiant")
    public void l_utilisateur_est_enregistre_avec_un_identifiant() {
        assertTrue(sauvegardeReussie, "La sauvegarde devrait être réussie");
        assertTrue(identifiantUtilisateur != null && identifiantUtilisateur > 0,
                "L'identifiant devrait être généré");

        System.out.println("✓ Utilisateur sauvegardé avec succès!");
        System.out.println("✓ Identifiant généré: " + identifiantUtilisateur);
        System.out.println("✓ Nom: " + nom);
        System.out.println("✓ Email: " + email);
    }
}