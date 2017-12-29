#!/usr/bin/env bash
set -e
if [ "${TRAVIS_PULL_REQUEST}" = "true" ]; then
  java -jar ./app/target/app-1.jar
fi
exit 0
