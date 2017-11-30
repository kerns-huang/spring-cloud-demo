FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./discover/build/libs/discover.jar app.jar
RUN sh -c 'touch /app.jar'
RUN sh -c 'mkdir -vp ~/logs/discover'
ENV LOG_HOME='/root/logs/discover'
ENV JAVA_OPTS="-Dspring.profiles.active=dev -server -verbose:gc -Xms128m -Xmx128m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xss256k -Xloggc:$LOG_HOME/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_HOME/HeapDumpOnOutOfMemoryError.log -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:MaxGCPauseMillis=10 -XX:GCPauseIntervalMillis=200 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:InitialBootClassLoaderMetaspaceSize=64m"
EXPOSE 38084
EXPOSE 30884
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]