
@echo off
cd ..\classes
jar cvf authrmi_main.jar authrmi\*.class authrmi\permissions\*.class authrmi\exceptions\*.class
jar cvf authrmi_actions.jar authrmi\actions\*.class 
move *.jar ..\deployment
cd ..\deployment
