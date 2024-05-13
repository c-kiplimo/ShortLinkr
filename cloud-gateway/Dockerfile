FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9191
ADD target/cloud-gateway-0.0.1.jar  cloud-gateway-0.0.1.jar
RUN ls -ltrh /
ENV JVM_OPTS=""

ENV SPRING_OPTS=""
ENTRYPOINT ["java", "-jar" , "cloud-gateway-0.0.1.jar"]