FROM alpine:latest
ENV TZ=America/Sao_Paulo
COPY carrinho.jar /carrinho.jar
EXPOSE 8080
RUN apk --update add openjdk11
ENTRYPOINT ["java", "Xmx1g", "Duser.timezone='America/Sao_Paulo'", ".jar", "/carrinho.jar"]