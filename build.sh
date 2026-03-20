#!/bin/bash
set -e

mvn clean package -q

echo "Build successful. JAR located at target/UseFunctionalJMaven-0.0.1-SNAPSHOT.jar"
