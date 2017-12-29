#!/usr/bin/env bash
set -e
java -jar ./app/target/app-1.jar
if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
  mvn clean -rf :app
fi


