FROM maven:3.8.5-openjdk-17 as build
WORKDIR /usr/src/scaffolded
COPY . .
ARG MY_SECRET_DATABASE_URL
ARG MY_SECRET_USER
ARG MY_SECRET_PASSWORD
RUN mvn --batch-mode package
RUN cp target/*jar target/app.jar


FROM openjdk:18-ea-11-jdk-alpine3.15
USER 1000
ENTRYPOINT ["java","-jar", "./app.jar"]
EXPOSE 8080
COPY --from=build /usr/src/scaffolded/target/app.jar app.jar
