FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9091
ADD target/shortener-service-0.0.1.jar  shortener-service-0.0.1.jar
RUN ls -ltrh /
ENV JVM_OPTS=""

ENV SPRING_OPTS=""
ENTRYPOINT ["java", "-jar" , "shortener-service-0.0.1.jar"]