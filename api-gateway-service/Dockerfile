FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8085

ENV SPRING_PROFILES_ACTIVE=docker \
    EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka/ \
    SPRING_DATASOURCE_URL=jdbc:h2:file:/data/testdb

VOLUME /data

ENTRYPOINT ["java", "-jar", "/app/app.jar"] 