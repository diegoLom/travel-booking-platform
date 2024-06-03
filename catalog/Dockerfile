# Java version
FROM openjdk:17-alpine

#working directory
WORKDIR /app


#jar file
COPY target/catalog-0.0.1-SNAPSHOT.jar /app/catalog.jar

#Create logs directory
RUN mkdir -p /app/logs

#Expose the port that the Spring Boot application will run on 
EXPOSE 8082

#Specify the command to run the Spring Boot application 
CMD ["java", "-jar", "catalog.jar"]
