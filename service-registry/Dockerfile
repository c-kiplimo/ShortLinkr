FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8761
ADD target/service-registry-0.0.1.jar  service-registry-0.0.1.jar
RUN ls -ltrh /
ENV JVM_OPTS=""

ENV SPRING_OPTS=""
ENTRYPOINT ["java", "-jar" , "service-registry-0.0.1.jar"]


# scp root@164.92.70.172:/root/apps/linkify/docker-compose.yml  /Users/tevinmillaogutu/Documents/Alx