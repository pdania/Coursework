#!/usr/bin/env bash

VERSION="3.19-SNAPSHOT"

set -e

rm -rf project

mkdir -p project/src/main/java

wget http://pullenti.ru/DownloadFile.aspx?file=PullentiJava.zip -O PullentiJava.zip
unzip PullentiJava.zip -d project
rm -f PullentiJava.zip

mv project/com project/src/main/java/com
sed "s/%VERSION%/$VERSION/g" pom.xml.template > project/pom.xml

pushd project
mvn install
popd
