#!/usr/bin/env bash
#export APPVEYOR_TOKEN="nchltpd0dyswqfwjuly4"
#curl -H "Authorization: Bearer $APPVEYOR_TOKEN" -H "Content-Type: application/json" https://ci.appveyor.com/api/roles

curl -X POST \
  https://ci.appveyor.com/api/builds \
  -H 'Authorization\": Bearer 3mb5uv6nmjl3l80ebsat' \
  -H 'Content-Type: application/json' \
  -d '{accountName = "ordeh"; projectSlug = "task-delivery"}'

#endpoint=https://api.travis-ci.com


#function travis-api {
 # curl -s $endpoint$1 \
  #     -H "Authorization: Bearer $APPVEYOR_TOKEN" \
   #    -H 'Content-Type: application/json' \
    #   "${@:2}"
#}