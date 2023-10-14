From openjdk:8-jdk-alpine
copy ./target/gestion-station-ski-1.0.jar app.jar
CMD ["java","-jar","app.jar"]