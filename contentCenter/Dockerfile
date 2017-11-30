FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./contentCenter/build/libs/contentCenter.jar app.jar
RUN sh -c 'touch /app.jar'
RUN sh -c 'mkdir -vp ~/logs/contentCenter'
ENV LOG_HOME='/root/logs/contentCenter'
ENV JAVA_OPTS="-Dspring.profiles.active=dev -server -verbose:gc -Xms128m -Xmx128m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xss256k -Xloggc:$LOG_HOME/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_HOME/HeapDumpOnOutOfMemoryError.log -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:MaxGCPauseMillis=10 -XX:GCPauseIntervalMillis=200 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:InitialBootClassLoaderMetaspaceSize=64m"
EXPOSE 38083
EXPOSE 30883
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]