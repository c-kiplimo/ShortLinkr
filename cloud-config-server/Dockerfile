FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9296
ADD target/cloud-config-server-0.0.1.jar  cloud-config-server-0.0.1.jar
RUN ls -ltrh /
ENV JVM_OPTS=""

ENV SPRING_OPTS=""
ENTRYPOINT ["java", "-jar" , "cloud-config-server-0.0.1.jar"]