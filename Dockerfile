FROM centos
RUN dnf install -y java-11-openjdk.x86_64
VOLUME /tmp
ADD /recipe-app-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/myapp.jar"]
