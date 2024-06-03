# Java version
FROM openjdk:17-alpine

#working directory
WORKDIR /app


#jar file
COPY target/configServer-0.0.1-SNAPSHOT.jar /app/configServer.jar

#Expose the port that the Spring Boot application will run on 
EXPOSE 8071

#Specify the command to run the Spring Boot application 
CMD ["java", "-jar", "configServer.jar"]
