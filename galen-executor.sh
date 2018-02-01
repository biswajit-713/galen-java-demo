#!/bin/bash

./gradlew responsivenessTest -Dgalen.device=chrome
echo $?
