#!/bin/zsh

# Switch to JDK 14 with jpackage
eval "$(jenv init -)"
jenv shell 14-jpackage
java -version

# Package the application for Mac OS
jpackage --type dmg \
         --dest target/installer \
         --name mywebapp \
         --module-path target/simple-web-app-1.0-SNAPSHOT.jar \
         --module example.web/com.example.App
