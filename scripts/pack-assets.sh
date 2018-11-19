#!/usr/bin/env bash



cd ./src/main/resources/public/
npm install
npm run-script pack-assets
rm -rf node_modules
rm -rf src