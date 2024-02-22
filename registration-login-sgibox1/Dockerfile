FROM amazoncorretto:21
LABEL description = "An Image to run the login service from sgibox1"
LABEL authors="JhonatanJesusArceGon"
COPY target/registration-login-sgibox1-0.0.1-SNAPSHOT.jar registration-login-sgibox1-0.jar
ENTRYPOINT ["java", "-jar", "registration-login-sgibox1-0.jar"]