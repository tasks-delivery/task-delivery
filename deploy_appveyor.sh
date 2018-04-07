#!/bin/sh
curl -X POST -H "Authorization:Bearer 3mb5uv6nmjl3l80ebsat" -H "Content-Type:application/json" -d "{\"accountName\": \"ordeh\",\"projectSlug\": \"task-delivery\"}" https://ci.appveyor.com/api/builds

