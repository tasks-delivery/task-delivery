#!/bin/sh
curl -X POST -H "Authorization:Bearer $APPVEYOR_TOKEN" -H "Content-Type:application/json" -d "{\"accountName\": \"$APPVEYOR_USERNAME\",\"projectSlug\": \"task-delivery\"}" https://ci.appveyor.com/api/builds