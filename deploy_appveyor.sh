#!/usr/bin/env bash
curl -s -X POST \
   -H "Content-Type: application/json" \
   -H "Accept: application/json" \
   -H "Travis-API-Version: 3" \
   -H "Authorization: token $APPVEYOR_TOKEN" \
   -d '{accountName = "ordeh"; projectSlug = "task-delivery"}' \
   https://ci.appveyor.com/api/builds
endpoint=https://ci.appveyor.com/api/builds
