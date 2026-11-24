#!/usr/bin/env sh
set -eu

mkdir -p out/test
javac -d out/test $(find src -name '*.java' -print)
java -ea -cp out/test Main
