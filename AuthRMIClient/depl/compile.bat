@echo off
javac -d ..\classes ..\src\authrmi\*.java ..\src\authrmi\exceptions\*.java ..\src\authrmi\permissions\*.java

call deploy.bat