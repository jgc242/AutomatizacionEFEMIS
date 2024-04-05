FROM maven:3.6.3-jdk-11 AS builder

WORKDIR /app

COPY . .

COPY pom.xml .

RUN mvn clean install

FROM openjdk:11

WORKDIR /app

COPY --from=builder /target/efemis.jar /app

CMD ["java", "-jar", "efemis.jar"]