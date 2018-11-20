#!/usr/bin/env bash

brew install heroku/brew/heroku
heroku create spring-boot-campaign

git add ./src/main/resources/public
git commit -m "bundled assets"

git push -f heroku master
heroku ps:scale web=1
