# Utiliser une image de base avec Java 17
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR du projet
COPY target/*.jar app.jar

# Exposer le port utilisé par l'application
EXPOSE 8081

# Variables d'environnement pour la configuration
ENV SPRING_PROFILES_ACTIVE=docker \
    EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka/ \
    SPRING_DATASOURCE_URL=jdbc:h2:file:/data/testdb

# Créer un volume pour persister les données H2
VOLUME /data

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "/app/app.jar"] 