# This is stored in the java project but copied into the ../work folder before it is run
FROM java:8-jdk
MAINTAINER datafundamentals <pete@datafundamentals.com> "https://github.com/datafundamentals"
ENV JAR_LOCATION .
ENV JAR_PORT 8942
ENV JAR_NAME contrasting.jar
COPY wordList.txt /
WORKDIR /usr/lib
ADD . /usr/lib
CMD [ "java", "-jar", "contrasting.jar" ]
EXPOSE $JAR_PORT