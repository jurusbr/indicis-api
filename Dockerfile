FROM openjdk:14-jdk-alpine
RUN addgroup -S indicis && adduser -S indicis -G indicis
USER indicis:indicis
ARG JAR_FILE=target/*.jar 
COPY ${JAR_FILE} app.jar
ENV DB_URL=jdbc:postgresql:///postgres?socketFactory=com.google.cloud.sql.postgres.SocketFactory&cloudSqlInstance=jurus-01:southamerica-east1:sql-dev&user=dbuser&password=frhnd2330
ENV DB_USER=dbuser
ENV DB_PASSWORD=frhnd2330
ENTRYPOINT ["java","-jar","app.jar"]
