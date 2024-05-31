#Build stage

FROM gradle:latest AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle clean build

# Package stage

FROM openjdk:latest
ENV JAR_NAME=cimbaAI-springboot-api-service-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME

#build: docker build -t vaskar007/backend-java-springboot-service:latest .
#run: docker run -p 8080:8080 vaskar007/backend-java-springboot-service:latest