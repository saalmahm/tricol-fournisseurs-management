package com.salma.controller;

import com.salma.model.Fournisseur;
import com.salma.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController  
@RequestMapping("/api/v1/fournisseurs") 
@CrossOrigin(origins = "*")  
public class FournisseurController {

    private final FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public ResponseEntity<List<Fournisseur>> obtenirTousFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.obtenirTousFournisseurs();
        return ResponseEntity.ok(fournisseurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> obtenirFournisseurParId(@PathVariable Long id) {
        return fournisseurService.obtenirFournisseurParId(id)
                .map(ResponseEntity::ok)  // Si trouvé : 200 OK
                .orElse(ResponseEntity.notFound().build());  // Si non trouvé : 404 Not Found
    }

    @PostMapping
    public ResponseEntity<Fournisseur> creerFournisseur(@Valid @RequestBody Fournisseur fournisseur) {
        try {
            Fournisseur nouveauFournisseur = fournisseurService.creerFournisseur(fournisseur);
            return ResponseEntity.status(HttpStatus.CREATED).body(nouveauFournisseur);  // 201 Created
        } catch (IllegalArgumentException e) {
            // Si ICE ou email déjà existant
            return ResponseEntity.badRequest().build();  // 400 Bad Request
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> modifierFournisseur(
            @PathVariable Long id,
            @Valid @RequestBody Fournisseur fournisseur) {
        try {
            Fournisseur fournisseurModifie = fournisseurService.modifierFournisseur(id, fournisseur);
            return ResponseEntity.ok(fournisseurModifie);  // 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFournisseur(@PathVariable Long id) {
        try {
            fournisseurService.supprimerFournisseur(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Fournisseur>> rechercherFournisseurs(@RequestParam String keyword) {
        List<Fournisseur> fournisseurs = fournisseurService.rechercherParSociete(keyword);
        return ResponseEntity.ok(fournisseurs);
    }

    @GetMapping("/ville/{ville}")
    public ResponseEntity<List<Fournisseur>> obtenirFournisseursParVille(@PathVariable String ville) {
        List<Fournisseur> fournisseurs = fournisseurService.obtenirFournisseursParVille(ville);
        return ResponseEntity.ok(fournisseurs);
    }
}