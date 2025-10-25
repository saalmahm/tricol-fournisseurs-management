package com.salma.repository;

import com.salma.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    List<Fournisseur> findByVille(String ville);

    List<Fournisseur> findBySocieteContainingIgnoreCase(String keyword);

    boolean existsByIce(String ice);

    boolean existsByEmail(String email);
}