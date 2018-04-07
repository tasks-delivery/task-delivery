#!/usr/bin/env bash
#export APPVEYOR_TOKEN="nchltpd0dyswqfwjuly4"
#curl -H "Authorization: Bearer $APPVEYOR_TOKEN" -H "Content-Type: application/json" https://ci.appveyor.com/api/roles

endpoint=https://ci.appveyor.com/api/builds

function travis-api {
 curl -s $endpoint$1 \
      -H "Authorization: Bearer $APPVEYOR_TOKEN" \
      -H 'Content-Type: application/json' \
      -d '{accountName = "ordeh"; projectSlug = "task-delivery"}' \
      "${@:2}"
}