FROM java:8
ADD  target/joker-docker.jar joker-docker.jar
ADD  config.yml config.yml
EXPOSE 8080 8081
ENTRYPOINT ["java", "-jar", "joker-docker.jar", "server", "config.yml"]