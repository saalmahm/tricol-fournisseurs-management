<div align="center">

# 🧵 Tricol - Gestion des Fournisseurs

<img src="https://img.shields.io/badge/Java-11-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
<img src="https://img.shields.io/badge/Spring-5.3.30-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"/>
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
<img src="https://img.shields.io/badge/Apache%20Tomcat-9.0-F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black" alt="Tomcat"/>
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven"/>


</div>

---

## 📋 Description


Application web Java développée avec **Spring Core** (sans Spring Boot) pour gérer les fournisseurs de l'entreprise Tricol. L'application expose une API REST complète pour effectuer des opérations CRUD sur les fournisseurs.

## 🛠️ Technologies Utilisées

<table>
<tr>
<td align="center" width="96">
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" width="48" height="48" alt="Java" />
<br>Java 11
</td>
<td align="center" width="96">
<img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" width="48" height="48" alt="Spring" />
<br>Spring 5.3.30
</td>
<td align="center" width="96">
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" width="48" height="48" alt="PostgreSQL" />
<br>PostgreSQL
</td>
<td align="center" width="96">
<img src="https://www.vectorlogo.zone/logos/hibernate/hibernate-icon.svg" width="48" height="48" alt="Hibernate" />
<br>Hibernate 5.6
</td>
<td align="center" width="96">
<img src="https://www.vectorlogo.zone/logos/apache_tomcat/apache_tomcat-icon.svg" width="48" height="48" alt="Tomcat" />
<br>Tomcat 9.0
</td>
<td align="center" width="96">
<img src="https://www.vectorlogo.zone/logos/apache_maven/apache_maven-icon.svg" width="48" height="48" alt="Maven" />
<br>Maven
</td>
</tr>
</table>

## 🏗️ Architecture

<div align="center">

```mermaid
graph TB
    A[🌐 Client HTTP] -->|Request| B[Controller Layer]
    B -->|Business Logic| C[Service Layer]
    C -->|Data Access| D[Repository Layer]
    D -->|SQL Queries| E[(PostgreSQL Database)]
    
    style A fill:#e1f5ff
    style B fill:#fff4e1
    style C fill:#f0fff4
    style D fill:#fff0f5
    style E fill:#f5f0ff
```

</div>


### 📁 Structure du Projet

```
src/main/java/com/salma/
├── 🔧 config/                       # Configuration Spring
│   ├── AppConfig.java              # Configuration principale
│   ├── JpaConfig.java              # Configuration JPA/Hibernate
│   ├── WebConfig.java              # Configuration Spring MVC
│   └── WebAppInitializer.java     # Initialisation (remplace web.xml)
├── 🎮 controller/                   # Contrôleurs REST
│   ├── FournisseurController.java
│   └── HomeController.java
├── 📦 model/                        # Entités JPA
│   └── Fournisseur.java
├── 🗄️ repository/                   # Repositories Spring Data JPA
│   └── FournisseurRepository.java
└── ⚙️ service/                      # Services métier
    ├── FournisseurService.java
    └── impl/
        └── FournisseurServiceImpl.java
```

## 📦 Prérequis

<div align="center">

| Outil | Version | Badge |
|-------|---------|-------|
| Java JDK | 11+ | ![Java](https://img.shields.io/badge/JDK-11+-ED8B00?style=flat-square&logo=openjdk) |
| Maven | 3.6+ | ![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=flat-square&logo=apache-maven) |
| PostgreSQL | 12+ | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-12+-316192?style=flat-square&logo=postgresql) |
| Tomcat | 9.0.111 | ![Tomcat](https://img.shields.io/badge/Tomcat-9.0.111-F8DC75?style=flat-square&logo=apache-tomcat) |
| IntelliJ IDEA | Recommandé | ![IntelliJ](https://img.shields.io/badge/IntelliJ-IDEA-000000?style=flat-square&logo=intellij-idea) |

</div>

## 🚀 Installation et Configuration

### 1️⃣ Cloner le projet

```bash
git clone https://github.com/saalmahm/tricol-fournisseurs-management
cd tricol-fournisseurs-management
```

### 2️⃣ Configurer PostgreSQL

Créez la base de données :

```sql
CREATE DATABASE tricol_fournisseurs;
```

<div align="center">
<img src="https://img.shields.io/badge/Database-PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL Database"/>
</div>

### 3️⃣ Configurer application.properties

Modifiez `src/main/resources/application.properties` :

```properties
# Configuration PostgreSQL
db.driver=org.postgresql.Driver
db.url=jdbc:postgresql://localhost:5432/tricol_fournisseurs
db.username=votre_username
db.password=votre_password

# Hibernate Configuration
hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
hibernate.show_sql=true
hibernate.format_sql=true
hibernate.hbm2ddl.auto=update
```

### 4️⃣ Compiler le projet

```bash
mvn clean package
```

<div align="center">
<img src="https://img.shields.io/badge/Build-Success-4CAF50?style=for-the-badge" alt="Build Success"/>
</div>

### 5️⃣ Déployer sur Tomcat

#### 🖥️ Option A : Via IntelliJ IDEA

1. File → Settings → Application Servers → + → Tomcat Server
2. Configurer le chemin Tomcat : `C:\apache-tomcat-9.0.111`
3. Run → Edit Configurations → + → Tomcat Server → Local
4. Deployment → + → Artifact → `tricol-fournisseurs-management:war exploded`
5. Application context : `/tricol`
6. Cliquer sur Run ▶️

#### 🔧 Option B : Déploiement manuel

```bash
cp target/tricol-fournisseurs-management-1.0-SNAPSHOT.war $TOMCAT_HOME/webapps/tricol.war
$TOMCAT_HOME/bin/startup.sh
```

## 🌐 Endpoints API

### 💚 Health Check

```
GET http://localhost:8080/tricol/
```

<div align="center">

**Réponse :**

```json
{
  "status": "UP",
  "message": "✅ Application Tricol fonctionne !",
  "application": "Gestion des Fournisseurs",
  "version": "1.0-SNAPSHOT"
}
```

<img src="https://img.shields.io/badge/Status-UP-4CAF50?style=for-the-badge" alt="Status UP"/>

</div>

### 📋 Fournisseurs

<div align="center">

| Méthode | Endpoint | Description | Status |
|---------|----------|-------------|--------|
| ![GET](https://img.shields.io/badge/GET-61AFFE?style=flat-square) | `/api/v1/fournisseurs` | Liste tous les fournisseurs | ✅ |
| ![GET](https://img.shields.io/badge/GET-61AFFE?style=flat-square) | `/api/v1/fournisseurs/{id}` | Récupère un fournisseur par ID | ✅ |
| ![POST](https://img.shields.io/badge/POST-49CC90?style=flat-square) | `/api/v1/fournisseurs` | Crée un nouveau fournisseur | ✅ |
| ![PUT](https://img.shields.io/badge/PUT-FCA130?style=flat-square) | `/api/v1/fournisseurs/{id}` | Modifie un fournisseur | ✅ |
| ![DELETE](https://img.shields.io/badge/DELETE-F93E3E?style=flat-square) | `/api/v1/fournisseurs/{id}` | Supprime un fournisseur | ✅ |
| ![GET](https://img.shields.io/badge/GET-61AFFE?style=flat-square) | `/api/v1/fournisseurs/search?keyword=...` | Recherche par société | ✅ |
| ![GET](https://img.shields.io/badge/GET-61AFFE?style=flat-square) | `/api/v1/fournisseurs/ville/{ville}` | Filtre par ville | ✅ |

</div>

### 📝 Exemples de Requêtes

#### ➕ Créer un fournisseur (POST)

```bash
curl -X POST http://localhost:8080/tricol/api/v1/fournisseurs \
  -H "Content-Type: application/json" \
  -d '{
    "societe": "Tissus du Maroc SARL",
    "adresse": "Zone Industrielle Ain Sebaa",
    "contact": "Ahmed Bennani",
    "email": "contact@tissusmaroc.ma",
    "telephone": "0522-123456",
    "ville": "Casablanca",
    "ice": "001234567890123"
  }'
```

#### 📋 Récupérer tous les fournisseurs (GET)

```bash
curl http://localhost:8080/tricol/api/v1/fournisseurs
```

## 📊 Modèle de Données

### 🏢 Entité Fournisseur

<div align="center">

| Champ | Type | Contraintes | Icon |
|-------|------|-------------|------|
| id | Long | 🔑 Clé primaire, auto-incrémenté | 🆔 |
| societe | String | ✅ Obligatoire, 2-100 caractères | 🏢 |
| adresse | String | ✅ Obligatoire, max 255 caractères | 📍 |
| contact | String | ✅ Obligatoire, 2-100 caractères | 👤 |
| email | String | ✅ Obligatoire, unique, format email | 📧 |
| telephone | String | ✅ Obligatoire, 10-20 caractères | 📞 |
| ville | String | ✅ Obligatoire, 2-50 caractères | 🌆 |
| ice | String | ✅ Obligatoire, unique, 15 caractères | 🔢 |

</div>

## 🧪 Tests

### 🔵 Avec Postman

<div align="center">
<img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" width="60" height="60" alt="Postman"/>
</div>

1. Téléchargez Postman
2. Importez la collection (si disponible)
3. Testez les endpoints

### 🟢 Avec cURL

Voir les exemples dans la section Endpoints API

## 📝 Concepts Spring Utilisés

<div align="center">

| Concept | Description | Badge |
|---------|-------------|-------|
| IoC | Inversion of Control | ![IoC](https://img.shields.io/badge/Spring-IoC-6DB33F?style=flat-square) |
| DI | Dependency Injection | ![DI](https://img.shields.io/badge/Spring-DI-6DB33F?style=flat-square) |
| JPA | Spring Data JPA | ![JPA](https://img.shields.io/badge/Spring-JPA-6DB33F?style=flat-square) |
| Transaction | @Transactional | ![TX](https://img.shields.io/badge/Spring-TX-6DB33F?style=flat-square) |
| Validation | Bean Validation | ![Valid](https://img.shields.io/badge/Java-Validation-ED8B00?style=flat-square) |
| REST | @RestController | ![REST](https://img.shields.io/badge/Spring-REST-6DB33F?style=flat-square) |

</div>

---

## 👨‍💻 Auteur

**Saalma hm** - [GitHub](https://github.com/saalmahm)

---

⭐ N'oubliez pas de donner une étoile si ce projet vous a été utile !