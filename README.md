Linux test
[![Build Status](https://travis-ci.org/tasks-delivery/task-delivery.svg?branch=master)](https://travis-ci.org/tasks-delivery/task-delivery/settings)  

Windows test
[![Build status](https://ci.appveyor.com/api/projects/status/gqojfgdgpv11k6nb?svg=true)](https://ci.appveyor.com/project/ordeh/task-delivery)

Manual deploy on heroku
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/tasks-delivery/task-delivery)
[![Deploy to now](https://deploy.now.sh/static/button.svg)](https://deploy.now.sh/?repo=https://github.com/tasks-delivery/task-delivery)

Deploy on heroku via Codeship
[ ![Codeship Status for tasks-delivery/task-delivery](https://app.codeship.com/projects/6bd0a770-eefb-0135-eccb-2e99b60e2a7c/status?branch=master)](https://app.codeship.com/projects/271037)

Code analysis
[![BCH compliance](https://bettercodehub.com/edge/badge/tasks-delivery/task-delivery?branch=master)](https://bettercodehub.com/)

Build script for appveyor
mvn test -P windows-firefox
mvn test -P windows-chrome
mvn clean package -DskipTests=true
appveyor PushArtifact C:\projects\task-delivery\target\app.jar -DeploymentName task-delivery.jar