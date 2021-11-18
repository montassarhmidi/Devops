FROM openjdk:8-jdk-alpine
EXPOSE 8085
ADD /target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.4.war Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.4
ENTRYPOINT ["java", "-jar", "Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.4"]
