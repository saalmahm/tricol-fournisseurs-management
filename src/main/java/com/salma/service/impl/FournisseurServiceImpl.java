package com.salma.service.impl;

import com.salma.model.Fournisseur;
import com.salma.repository.FournisseurRepository;
import com.salma.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service  
@Transactional  // Gère automatiquement les transactions de base de données
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public Fournisseur creerFournisseur(Fournisseur fournisseur) {
        // Vérifier si l'ICE existe déjà
        if (fournisseurRepository.existsByIce(fournisseur.getIce())) {
            throw new IllegalArgumentException("Un fournisseur avec cet ICE existe déjà : " + fournisseur.getIce());
        }

        // Vérifier si l'email existe déjà
        if (fournisseurRepository.existsByEmail(fournisseur.getEmail())) {
            throw new IllegalArgumentException("Un fournisseur avec cet email existe déjà : " + fournisseur.getEmail());
        }

        // Sauvegarder le fournisseur
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    @Transactional(readOnly = true)  // Optimisation pour les lectures seules
    public List<Fournisseur> obtenirTousFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fournisseur> obtenirFournisseurParId(Long id) {
        return fournisseurRepository.findById(id);
    }

    @Override
    public Fournisseur modifierFournisseur(Long id, Fournisseur fournisseurModifie) {
        // Vérifier que le fournisseur existe
        Fournisseur fournisseurExistant = fournisseurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fournisseur non trouvé avec l'ID : " + id));

        // Vérifier que l'ICE n'est pas déjà utilisé par un autre fournisseur
        if (!fournisseurExistant.getIce().equals(fournisseurModifie.getIce()) 
                && fournisseurRepository.existsByIce(fournisseurModifie.getIce())) {
            throw new IllegalArgumentException("Un autre fournisseur utilise déjà cet ICE : " + fournisseurModifie.getIce());
        }

        // Vérifier que l'email n'est pas déjà utilisé par un autre fournisseur
        if (!fournisseurExistant.getEmail().equals(fournisseurModifie.getEmail()) 
                && fournisseurRepository.existsByEmail(fournisseurModifie.getEmail())) {
            throw new IllegalArgumentException("Un autre fournisseur utilise déjà cet email : " + fournisseurModifie.getEmail());
        }

        // Mettre à jour les champs
        fournisseurExistant.setSociete(fournisseurModifie.getSociete());
        fournisseurExistant.setAdresse(fournisseurModifie.getAdresse());
        fournisseurExistant.setContact(fournisseurModifie.getContact());
        fournisseurExistant.setEmail(fournisseurModifie.getEmail());
        fournisseurExistant.setTelephone(fournisseurModifie.getTelephone());
        fournisseurExistant.setVille(fournisseurModifie.getVille());
        fournisseurExistant.setIce(fournisseurModifie.getIce());

        // Sauvegarder les modifications
        return fournisseurRepository.save(fournisseurExistant);
    }

    @Override
    public void supprimerFournisseur(Long id) {
        // Vérifier que le fournisseur existe
        if (!fournisseurRepository.existsById(id)) {
            throw new IllegalArgumentException("Fournisseur non trouvé avec l'ID : " + id);
        }

        // Supprimer le fournisseur
        fournisseurRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Fournisseur> rechercherParSociete(String keyword) {
        return fournisseurRepository.findBySocieteContainingIgnoreCase(keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Fournisseur> obtenirFournisseursParVille(String ville) {
        return fournisseurRepository.findByVille(ville);
    }
}