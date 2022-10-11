FROM openjdk:11
EXPOSE 8090
ADD target/productManagement.jar productManagement.jar
ENTRYPOINT ["java","-jar","/productManagement.jar"]