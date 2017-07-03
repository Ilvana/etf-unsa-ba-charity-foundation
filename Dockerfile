FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/etf-unsa-ba-charity-foundation.jar etfunsabacharityfoundation.jar
RUN sh -c 'touch /etfunsabacharityfoundation.jar'
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /etfunsabacharityfoundation.jar" ]
