package com.salma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "✅ Application Tricol fonctionne !");
        response.put("application", "Gestion des Fournisseurs");
        response.put("version", "1.0-SNAPSHOT");
        return response;
    }

    @GetMapping("/api/v1/test")
    public String test() {
        return "✅ API REST fonctionne ! Accédez aux fournisseurs sur /api/v1/fournisseurs";
    }
}