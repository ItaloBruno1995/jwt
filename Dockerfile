From openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS =${ADDITIONAL_OPTS}

WORKDIR /seguranca

COPY /target/spring-seguranca*.jar spring-seguranca-1.0.0-SNAPSHOT.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar spring-seguranca-1.0.0-SNAPSHOT.jar --spring_profiles.active=${PROFILE}