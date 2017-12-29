#!/usr/bin/env bash
set -ev
if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
  java -jar ./app/target/app-1.jar
  continue
fi
done
exit "0"
