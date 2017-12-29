#!/usr/bin/env bash
set -e
java -jar ./app/target/app-1.jar
if [ "${TRAVIS_PULL_REQUEST}" = "true" ]; then
  mvn clean -rf :app
fi

exit


