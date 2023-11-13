FROM amazoncorretto:17

ARG JAR_FILE=target/*.jar
WORKDIR /thymeleaf-spring

COPY . .
#RUN mvn clean install

#CMD mvn spring-boot:run

COPY ${JAR_FILE} thymeleaf.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/thymeleaf.jar"]


##FROM amazoncorretto:17
##ARG JAR_FILE=target/*.jar
##WORKDIR /opt/app
##COPY ${JAR_FILE} app.jar
##EXPOSE 8080
##ENTRYPOINT ["java", "-jar", "/app.jar"]
