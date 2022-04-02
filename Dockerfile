FROM openjdk:8-alpine

COPY target/uberjar/landing-page.jar /landing-page/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/landing-page/app.jar"]
