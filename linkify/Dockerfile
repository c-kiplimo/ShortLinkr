FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9090
ADD target/linkify-0.0.1.jar  linkify-0.0.1.jar
RUN ls -ltrh /
ENV JVM_OPTS=""

ENV SPRING_OPTS=""
ENTRYPOINT ["java", "-jar" , "linkify-0.0.1.jar"]