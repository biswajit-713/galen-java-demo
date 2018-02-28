# galen-java-demo
Download Galen from http://galenframework.com/docs/getting-started-install-galen/

Prerequsites
1. Java
2. Galen Framework
3. Gradle 3.1 or above

Run the tests
OSX - $PLATFORM=local ./gradlew responsivenessTest -Dgalen.device=chromeDesktop -Denv=integration

Currently the test runs only on Chrome v61 and above.
