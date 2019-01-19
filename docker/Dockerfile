# Version 0.0.1
FROM java:8

MAINTAINER harbor luo "hluo@flexerasoftware.com"

#环境变量
ENV WORK_PATH /home/project/streamTacking
ENV APP_NAME demo-0.0.1-SNAPSHOT.jar
ENV APP_VERSION 1.0

EXPOSE 32102

#USER
#USER user:group

#VOLUME
VOLUME ["/home/project/stream-monitor", "/tmp/data"]

#ADD

#COPY
COPY $APP_NAME $WORK_PATH/

RUN echo "Asia/Shanghai" > /etc/timezone && \
         dpkg-reconfigure -f noninteractive tzdata

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

# WORKDIR
WORKDIR $WORK_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

# CMD
CMD ["-jar", "demo-0.0.1-SNAPSHOT.jar"]
