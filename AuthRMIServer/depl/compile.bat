@echo off
javac -d ..\classes ..\src\authrmi\*.java ..\src\authrmi\actions\*.java ..\src\authrmi\exceptions\*.java ..\src\authrmi\permissions\*.java
rmic -v1.2 -d ..\classes -classpath ..\classes authrmi.LoginImpl authrmi.ServerProxy

call deploy.bat