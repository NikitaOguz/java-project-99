FROM gradle:8.9-jdk21

ARG SENTRY_AUTH_TOKEN
ENV SENTRY_AUTH_TOKEN=${SENTRY_AUTH_TOKEN}

WORKDIR /

COPY . .

RUN ./gradlew installDist

ENV SPRING_PROFILES_ACTIVE=prod

CMD ./build/install/app/bin/app
