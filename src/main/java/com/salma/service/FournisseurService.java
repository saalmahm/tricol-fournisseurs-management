package com.salma.service;

import com.salma.model.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {

    Fournisseur creerFournisseur(Fournisseur fournisseur);

    List<Fournisseur> obtenirTousFournisseurs();

    Optional<Fournisseur> obtenirFournisseurParId(Long id);

    Fournisseur modifierFournisseur(Long id, Fournisseur fournisseur);

    void supprimerFournisseur(Long id);

    List<Fournisseur> rechercherParSociete(String keyword);

    List<Fournisseur> obtenirFournisseursParVille(String ville);
}