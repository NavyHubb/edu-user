FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y \
    telnet \
    curl \
    jq \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 80

CMD ["java", "-jar", "app.jar"]