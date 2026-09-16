#!/usr/bin/env bash
set -e
rm -rf out
mkdir out
javac -d out $(buscar src/main/java -nome "*.java")
java -cp out br.edu.edusmart.Main
