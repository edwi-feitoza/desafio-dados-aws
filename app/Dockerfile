FROM eclipse-temurin:21.0.3_9-jdk-ubi9-minimal

LABEL maintainer="Edwi Feitoza <edwi.slacker@gmail.com>"
WORKDIR /app
COPY . .
RUN mvn package
CMD ["java", "-jar", "target/desafio-dados-0.0.1-SNAPSHOT.jar"]