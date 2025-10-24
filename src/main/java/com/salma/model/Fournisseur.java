package com.salma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fournisseurs")
@Data  // Lombok génère automatiquement getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Constructeur sans paramètres
@AllArgsConstructor  // Constructeur avec tous les paramètres
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la société est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    @Column(name = "societe", nullable = false, length = 100)
    private String societe;

    @NotBlank(message = "L'adresse est obligatoire")
    @Column(name = "adresse", nullable = false, length = 255)
    private String adresse;

    @NotBlank(message = "Le contact est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom du contact doit contenir entre 2 et 100 caractères")
    @Column(name = "contact", nullable = false, length = 100)
    private String contact;


    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;


    @NotBlank(message = "Le téléphone est obligatoire")
    @Size(min = 10, max = 20, message = "Le téléphone doit contenir entre 10 et 20 caractères")
    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @NotBlank(message = "La ville est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom de la ville doit contenir entre 2 et 50 caractères")
    @Column(name = "ville", nullable = false, length = 50)
    private String ville;

    /**
     * ICE (Identifiant Commun de l'Entreprise) - Identifiant fiscal marocain
     * Format: 15 chiffres
     */
    @NotBlank(message = "L'ICE est obligatoire")
    @Size(min = 15, max = 15, message = "L'ICE doit contenir exactement 15 caractères")
    @Column(name = "ice", nullable = false, unique = true, length = 15)
    private String ice;
}